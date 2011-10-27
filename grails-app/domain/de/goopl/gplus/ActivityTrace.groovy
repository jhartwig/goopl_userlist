package de.goopl.gplus

class ActivityTrace {
    static mapWith = "mongo"

    String eventName
    String data
    Date createdAt

    static constraints = {
        createdAt nullable: true
    }
    def beforeInsert() {
        createdAt = new Date()
    }

    static mapping = {
        //version false
        cache true
    }
}
