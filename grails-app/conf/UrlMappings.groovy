class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

	    "/" {
            controller = "search"
            action = "showAddUser"
        }
		"500"(view:'/error')
	}
}
