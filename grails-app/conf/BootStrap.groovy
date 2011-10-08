import de.goopl.gplus.Job
import de.goopl.gplus.User

class BootStrap {

    def init = { servletContext ->

        // generate some jobs
        new Job(jobDescription: "Webdeveloper", country: "germany").save()
        new Job(jobDescription: "Webentwickler", country: "germany").save()
        new Job(jobDescription: "Müllfahrer", country: "germany").save()
        new Job(jobDescription: "Maler", country: "germany").save()
        new Job(jobDescription: "Kellner", country: "germany").save()
        new Job(jobDescription: "Cook", country: "england").save()

        // generate some users
        10.times {
            new User(googleId: "103536047065272654630"+it, skills:"webdeveloper, java", city: "dresden", jobStatus: true).save() // jan
            new User(googleId: "100912127446274756364"+it, skills:"webentwickler, php", city: "berlin", jobStatus: false).save() // sebastian
            new User(googleId: "107872863924772125172"+it, skills:"web,java", city: "berlin", gender: "male").save()  // mario
        }

    }
    def destroy = {
    }
}
