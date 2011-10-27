package de.goopl.gplus

class User {

    static mapWith = "mongo"
//    static transients = "google"

//    static searchable = {
//        only = ["skillTags", "cityTags", "jobTags"]
//        googleId index: "no", store: "yes"
//    }

    String googleId
    String gender
    Date createdAt
    Date updatedAt
    String displayName
    String url
    String aboutMe
    String kind
    String tagline
    Set<String> skillTags = []
    Set<String> cityTags = []
    Set<String> jobTags = []
    Boolean jobStatus
    // TODO: available from?
    // TODO later
    def organizations
    def image
    def urls
    def placesLived

    static constraints = {
        googleId unique: true, minSize: 10
        gender nullable: true, size: 4..10
        aboutMe nullable: true
        tagline nullable: true, maxSize: 255
        createdAt nullable: true
        updatedAt nullable: true
        displayName nullable: true, maxSize: 100
        url nullable: true, url: true
        kind nullable: true, maxSize: 30
//        tags nullable: true, maximumNumberOfParameters: 10
        skillTags nullable: true, maximumNumberOfParameters: 10
        cityTags nullable: true, maximumNumberOfParameters: 10
        jobTags nullable: true, maximumNumberOfParameters: 10
        jobStatus nullable: true
        // TODO later
        urls nullable: true
        organizations nullable: true
        image nullable: true
        placesLived nullable: true
    }

    def convTagStringsToSet() {
        // TODO, gpars
        ["skillTags", "cityTags", "jobTags"].each {tags ->
            if (this."$tags"?.size() > 0) {
                Set<String> nTags = []
                (this."$tags" as List).each {nTags.add(it.toLowerCase())}
                this."$tags".clear()
                this."$tags".addAll nTags
            }
        }
    }

    def beforeInsert() {
        createdAt = new Date()
        convTagStringsToSet()
        log.info "User inserted"
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "User inserted", data: googleId).save(flush: true)
        }
    }

    def beforeUpdate() {
        updatedAt = new Date()
        convTagStringsToSet()
        log.info "User updated"
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "User updated", data: googleId).save(flush: true)
        }
    }

    def beforeDelete() {
        log.info "User deleted"
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "User Deleted", data: googleId).save(flush: true)
        }
    }

    static mapping = {
//        version false
        cache true
    }
}
