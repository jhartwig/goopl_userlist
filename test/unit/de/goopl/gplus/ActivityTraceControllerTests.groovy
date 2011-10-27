package de.goopl.gplus

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import javax.servlet.http.HttpServletResponse

@TestFor(ActivityTraceController)
@Mock(ActivityTrace)
class ActivityTraceControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/activityTrace/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.activityTraceInstanceList.size() == 0
        assert model.activityTraceInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.activityTraceInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.activityTraceInstance != null
        assert view == '/activityTrace/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/activityTrace/show/1'
        assert controller.flash.message != null
        assert ActivityTrace.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/activityTrace/list'


        populateValidParams(params)
        def activityTrace = new ActivityTrace(params)

        assert activityTrace.save() != null

        params.id = activityTrace.id

        def model = controller.show()

        assert model.activityTraceInstance == activityTrace
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/activityTrace/list'


        populateValidParams(params)
        def activityTrace = new ActivityTrace(params)

        assert activityTrace.save() != null

        params.id = activityTrace.id

        def model = controller.edit()

        assert model.activityTraceInstance == activityTrace
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/activityTrace/list'

        response.reset()


        populateValidParams(params)
        def activityTrace = new ActivityTrace(params)

        assert activityTrace.save() != null

        // test invalid parameters in update
        params.id = activityTrace.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/activityTrace/edit"
        assert model.activityTraceInstance != null

        activityTrace.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/activityTrace/show/$activityTrace.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        activityTrace.clearErrors()

        populateValidParams(params)
        params.id = activityTrace.id
        params.version = -1
        controller.update()

        assert view == "/activityTrace/edit"
        assert model.activityTraceInstance != null
        assert model.activityTraceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/activityTrace/list'

        response.reset()

        populateValidParams(params)
        def activityTrace = new ActivityTrace(params)

        assert activityTrace.save() != null
        assert ActivityTrace.count() == 1

        params.id = activityTrace.id

        controller.delete()

        assert ActivityTrace.count() == 0
        assert ActivityTrace.get(activityTrace.id) == null
        assert response.redirectedUrl == '/activityTrace/list'
    }
}
