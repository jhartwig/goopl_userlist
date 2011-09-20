import de.goopl.gplus.User

class BootStrap {

    def init = { servletContext ->
        new User(googleId: "107872863924772125172", jobDescription: "webentwickler", createdAt: new Date().toTimestamp()).save()
        new User(googleId: "100912127446274756364", jobDescription: "webentwickler", createdAt: new Date().toTimestamp()).save()
        new User(googleId: "103536047065272654630", jobDescription: "taugenichts", createdAt: new Date().toTimestamp()).save()
        new User(googleId: "113649193572212992618", jobDescription: "architekt", createdAt: new Date().toTimestamp()).save()
    }
    def destroy = {
    }
}
