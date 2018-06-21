package com.udev.tskmngr

class ConnexionController {

    def index() { }

    def login = {

        if (request.get) {
            return // render the login view
        }

        def u = User.findByEmailAndMdp(params.email, params.mdp)

        if(u){
            session.user = u
            render session.user
            redirect(controller: "tache", action: "index")
            //u.email = params.email
            //u.mdp = params.mdp
        } else {
            flash.message = "login failed"
            redirect(action: "index")

            //render(view:"index")
        }
        //render u.email


    }

    def logout = {
        session.user = null
        redirect(action: "index")
    }
}
