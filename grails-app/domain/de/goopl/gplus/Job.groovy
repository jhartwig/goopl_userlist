package de.goopl.gplus

class Job {
    String jobDescription
    String country // TODO: id's from ENUM!
    Date createdAt
    Date updatedAt

    static constraints = {
        createdAt nullable: true
        updatedAt nullable: true
    }

    def beforeInsert() {
        createdAt = new Date()
        jobDescription = jobDescription?.toLowerCase()
        country = country?.toLowerCase()
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "Job inserted", data: jobDescription).save()
        }
    }

    def beforeUpdate() {
        updatedAt = new Date()
        jobDescription = jobDescription?.toLowerCase()
        country = country?.toLowerCase()
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "Job updated", data: jobDescription).save()
        }
    }

    def beforeDelete() {
        ActivityTrace.withNewSession {
            new ActivityTrace(eventName: "Job Deleted", data: jobDescription).save()
        }
    }

    static mapping = {
        version false
        cache true
    }
}
