package de.goopl.gplus

class User {
    String googleId
    String jobDescription
    Date createdAt
    //Date updatedAt
    static constraints = {
        jobDescription blank: false//, validator: { val, obj -> val in obj.toLowerCase() }
        googleId blank: false
        createdAt nullable: false
    }
}
