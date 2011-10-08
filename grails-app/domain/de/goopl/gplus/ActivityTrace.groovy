package de.goopl.gplus

class ActivityTrace {
    String eventName
    String data
    Date createdAt
    static constraints = {
        createdAt nullable: false
    }
    def beforeInsert() {
        createdAt = new Date()
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "User inserted", data: googleId).save()
        }
    }

    static mapping = {
        version false
        cache true
    }
}
