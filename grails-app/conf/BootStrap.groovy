class BootStrap {

//    def searchableService

    def init = { servletContext ->

        // TODO: just for init or change logic, cloud db will not be overwritten just updated

        // generate some users
        //10.times {
//        new User(googleId: "103536047065272654630", displayName: "Jan", url: "https://plus.google.com/103536047065272654630", jobTags: ["WebDeveloper", "Programmierung", "softwareentwicklung"] as Set, skillTags: ["groovy", "grails", "rabbitmq", "redis", "mongodb"], cityTags: ["Berlin", "drESDEN"], jobStatus: false).save() // jan
//        new User(googleId: "100912127446274756364", displayName: "Seba", url: "https://plus.google.com/100912127446274756364", jobTags: ["webdeveloper"], skillTags: ["webentwickler", "php", "css", "html", "drupal"] as List<String>, cityTags: ["berlin"] as List<String>, jobStatus: false).save() // sebastian
//        new User(googleId: "107872863924772125172", displayName: "Mar Ju", url: "https://plus.google.com/107872863924772125172", jobTags: ["softwareentwickler", "webdeveloper"] as List<String>, skillTags: ["web", "java", "css", "html", "drupal"] as List<String>, cityTags: ["berlin"] as List<String>, gender: "male", jobStatus: false).save()  // mario
//        new User(googleId: "113234381616072164989", displayName: "Steve", url: "https://plus.google.com/113234381616072164989", jobTags: ["webentwickler", "webdeveloper"] as List<String>, skillTags: ["google", "android"] as List<String>, cityTags: ["DRESDEN"] as List<String>, gender: "male", jobStatus: false).save()  // mario
        //}

        // Index all Hibernate mapped domain classes.
//        searchableService.reindex()

        // Index all status messages.
//        def statusMessages = User.list()
//        log.info "Indexing ${statusMessages.size()} users skill"
//        User.reindex(statusMessages)
//        log.info "Finished indexing"

    }

    def destroy = {
    }
}
