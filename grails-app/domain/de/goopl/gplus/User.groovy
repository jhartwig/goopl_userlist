package de.goopl.gplus

class User {

    static searchable = true // TODO: not at date, url, aboutMe, kind, tagline,

    String googleId
    String gender
    Date createdAt
    Date updatedAt
    String displayName
    String url
    String aboutMe
    String kind
    String tagline
    String skills
    String city
    Boolean jobStatus
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
        skills nullable: true
        city nullable: true
        jobStatus nullable: true
        // TODO later
        urls nullable: true
        organizations nullable: true
        image nullable: true
        placesLived nullable: true
    }

    def beforeInsert() {
        createdAt = new Date()
        skills = skills?.toLowerCase()
        city = city?.toLowerCase()
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "User inserted", data: googleId).save()
        }
    }

    def beforeUpdate() {
        updatedAt = new Date()
        skills = skills?.toLowerCase()
        city = city?.toLowerCase()
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "User updated", data: googleId).save()
        }
    }

    def beforeDelete() {
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "User Deleted", data: googleId).save()
        }
    }

    static mapping = {
        version false
        cache true
    }
}
