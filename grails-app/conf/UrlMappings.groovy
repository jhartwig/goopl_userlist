class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/"(view:"/home/index")
//        "/" {
//            controller = "home"
//            action = "index"
//        }
		"500"(view:'/error')

        "/admin/cfDashboard/$action?"(controller: 'cloudFoundryDashboard')

        "/admin/cfDashboard/application/$appName"(controller: 'cloudFoundryDashboard', action: 'application')

        "/admin/cfDashboard/service/$serviceName"(controller: 'cloudFoundryDashboard', action: 'service')

        "/admin/cfDashboard/files/$appName/$instanceIndex?"(controller: 'cloudFoundryDashboard', action: 'files')
	}
}
