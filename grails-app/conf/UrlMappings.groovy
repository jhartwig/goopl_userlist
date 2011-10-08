class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

	    "/" {
            controller = "registerUser"
            action = "index"
        }
		"500"(view:'/error')
	}
}
