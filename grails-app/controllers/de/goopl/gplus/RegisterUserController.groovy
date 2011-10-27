package de.goopl.gplus

import grails.converters.JSON

class RegisterUserController {

    def gplusApiService

    def index() { }

    def loadGoogleProfile() {
        // todo: try catch
        def str = gplusApiService.getPeople(params.gpId) // TODO: params with command
        def userInfo = JSON.parse(str?.toURL()?.getText())

        def createUserAndReturnHim = {
            userInfo << [googleId: userInfo.id]
            def user = new User(userInfo)
            if (user.save(flush: true, failOnError: true)) {
                rabbitSend 'search.sync', '', "${user.id}:${user.class.name}"
                log.info "[] created user with id[$userInfo.id]"
                return user
            } else { user.errors.allErrors.each { log.warn it } }
        }

        def getUserFromDbAndUpdate = {
            def user = User.findByGoogleId(userInfo.id)
            if (user) {
                userInfo.each {(it.key == "id") ? (user?.googleId = it.value) : (user[it.key] = it.value)}
                if (user.save(flush: true, failOnError: true)) {
                    rabbitSend 'search.sync', '', "${user.id}:${user.class.name}"
                    log.info "[] updated user from google with id[$userInfo.id]"
                    return user
                } else { user.errors.allErrors.each { log.warn it } }
            }

        }
        // get userInfoDb, if not exist, create user and return userInfoDb
        def model = [:]
        model.user = getUserFromDbAndUpdate() ?: createUserAndReturnHim()
        model.jobs = Job.list(sort: "jobDescription", order: "asc")

        render(new JSON([model])).toString() //[model: model]  // TODO: which data from google
    }

    def saveProfileToDb() {
        // TODO: params with command
        def user = User.findByGoogleId(params.gpId)
        if (params.delete || params.cancel) {
            user.delete()
            if (params.delete) {
                log.info "[] deleted user from gui with id[$params.gpId]"
                flash.message = "user.delete.message.success"
                flash.args = [params.gpId]
            } else log.info "[] canceled user from gui with id[$params.gpId]"

            redirect action: 'index'
        }
        else if (params.update) {
            user.aboutMe = params.aboutMe
            user.skills = params.jobs.collect {Job.get(it).jobDescription}.join(", ")
            if (user.save(flush: true, failOnError: true)) {
                rabbitSend 'search.sync', '', "${user.id}:${user.class.name}"
                log.info "[] updated user from gui with id[$params.gpId]"
            }
            else { user.errors.allErrors.each { log.warn it } }

            redirect controller: 'searchable', params: ["java"]
        }
    }
}