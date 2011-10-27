package de.goopl.gplus

import org.springframework.dao.DataIntegrityViolationException

class ActivityTraceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [activityTraceInstanceList: ActivityTrace.list(params), activityTraceInstanceTotal: ActivityTrace.count()]
    }

    def create() {
        [activityTraceInstance: new ActivityTrace(params)]
    }

    def save() {
        def activityTraceInstance = new ActivityTrace(params)
        if (!activityTraceInstance.save(flush: true)) {
            render(view: "create", model: [activityTraceInstance: activityTraceInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), activityTraceInstance.id])
        redirect(action: "show", id: activityTraceInstance.id)
    }

    def show() {
        def activityTraceInstance = ActivityTrace.get(params.id)
        if (!activityTraceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), params.id])
            redirect(action: "list")
            return
        }

        [activityTraceInstance: activityTraceInstance]
    }

    def edit() {
        def activityTraceInstance = ActivityTrace.get(params.id)
        if (!activityTraceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), params.id])
            redirect(action: "list")
            return
        }

        [activityTraceInstance: activityTraceInstance]


    }

    def update() {
        def activityTraceInstance = ActivityTrace.get(params.id)
        if (!activityTraceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (activityTraceInstance.version > version) {
                activityTraceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'activityTrace.label', default: 'ActivityTrace')] as Object[],
                          "Another user has updated this ActivityTrace while you were editing")
                render(view: "edit", model: [activityTraceInstance: activityTraceInstance])
                return
            }
        }

        activityTraceInstance.properties = params

        if (!activityTraceInstance.save(flush: true)) {
            render(view: "edit", model: [activityTraceInstance: activityTraceInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), activityTraceInstance.id])
        redirect(action: "show", id: activityTraceInstance.id)
    }

    def delete() {
        def activityTraceInstance = ActivityTrace.get(params.id)
        if (!activityTraceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), params.id])
            redirect(action: "list")
            return
        }

        try {
            activityTraceInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'activityTrace.label', default: 'ActivityTrace'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
