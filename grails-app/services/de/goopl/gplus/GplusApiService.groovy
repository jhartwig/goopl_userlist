package de.goopl.gplus

import org.codehaus.groovy.grails.commons.ConfigurationHolder

class GplusApiService {

    // This method lets you read information that people have shared publicly
    def getPeople(gpId) {
        "${ConfigurationHolder.config.google.gplus.url}/${ConfigurationHolder.config.google.gplus.people}/$gpId?key=${ConfigurationHolder.config.google.key}"
    }

    // This method searches for people
    def getPeopleSearch(query) {
        "${ConfigurationHolder.config.google.gplus.url}/${ConfigurationHolder.config.google.gplus.people}/?query=$query&key=${ConfigurationHolder.config.google.key}"
    }

    // This method searches across the body and comments of public posts
    def getActivities(query) {
        "${ConfigurationHolder.config.google.gplus.url}/${ConfigurationHolder.config.google.gplus.activities}/?query=$query&key=${ConfigurationHolder.config.google.key}"
    }

    // This method supports retrieving resharers
    def getActivitiesPeopleResharers(activityId) {
        "${ConfigurationHolder.config.google.gplus.url}/${ConfigurationHolder.config.google.gplus.activities}/$activityId/${ConfigurationHolder.config.google.gplus.people}/resharers?key=${ConfigurationHolder.config.google.key}"
    }

    // This method supports retrieving +1’ers
    def getActivitiesPeoplePlusoners(activityId) {
        "${ConfigurationHolder.config.google.gplus.url}/${ConfigurationHolder.config.google.gplus.activities}/$activityId/${ConfigurationHolder.config.google.gplus.people}/plusoners?key=${ConfigurationHolder.config.google.key}"
    }

    // This method lists all of the comments for an activity
    def getActivitiesComment(activityId) {
        "${ConfigurationHolder.config.google.gplus.url}/${ConfigurationHolder.config.google.gplus.activities}/$activityId/${ConfigurationHolder.config.google.gplus.people}/comments?key=${ConfigurationHolder.config.google.key}"
    }

    // This method gets a comment
    def getComment(commentId) {
        "${ConfigurationHolder.config.google.gplus.url}/${ConfigurationHolder.config.google.gplus.comment}/$commentId?key=${ConfigurationHolder.config.google.key}"
    }
}
