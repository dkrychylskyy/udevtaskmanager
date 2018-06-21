package udevtaskmanager

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(view:"/connexion/index")
        //"/"(view:"/indexSimple")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
