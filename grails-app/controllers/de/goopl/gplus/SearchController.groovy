package de.goopl.gplus

import grails.converters.JSON
import org.codehaus.groovy.grails.commons.cfg.ConfigurationHelper
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class SearchController {

    def index() {
        def model = ConfigurationHolder.config.jobDescriptions//["Architekt","Webentwickler", "Müllfahrer"]//g.message(code: "jobDescriptions")
        [model: model]
    }

    def showUserSearchResult(){

        def model = []
        println params
        def users = User.findAllByBeruf(params.jobDescription.toString().ignoreCase())

        users.each {
            def str = "https://www.googleapis.com/plus/v1/people/${it.googleId}?key=AIzaSyBplZkLayLfEY556fgQNWtfB3n5-gDWqfk"
            def userInfo = JSON.parse(str.toURL().getText())
            model << [gender: userInfo.gender, name: userInfo.displayName]
        }
        [model: model]
    }

    def showAddUser(){
        def model = ConfigurationHolder.config.jobDescriptions
        [model: model]

    }

    def saveUser(){
        println params
        def user = new User(params)
        user.createdAt = new Date()
        if (user.save()) {
            redirect(action: 'index')
        }
        else {
            user.errors.allErrors.each {
                println it
            }
        }
    }
}
