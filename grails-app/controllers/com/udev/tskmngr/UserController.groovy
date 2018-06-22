package com.udev.tskmngr

import grails.validation.ValidationException
import grails.web.servlet.mvc.GrailsParameterMap
import org.springframework.web.servlet.ModelAndView

import static org.springframework.http.HttpStatus.*

class UserController {

    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userService.list(params), model:[userCount: userService.count()]
    }

    def show(Long id) {
        respond userService.get(id)
    }

    def create() {
        respond new User(params)
    }

    def save(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userService.get(id)
    }

    def update(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def creerUtilisateurs(){
        List<User> userList
        JSONParsing jsonParsing = new JSONParsing()
        userList = jsonParsing.parserJsonFichier()
        int count
        count = userList.size()
        for (User usr : userList){
                // Recuperation les donnees : user et taches
                String nom = usr.getNom()
                String prenom = usr.getPrenom()
                String email = usr.getEmail()
                String mdp = usr.getMdp()

                Set<Tache> taches = usr.getTaches()
                Iterator iterator = taches.iterator()

                def newUser = new User(nom:nom, prenom: prenom, mdp: "1234", email: email).save(failOnError: true)

                //render "Succes ! "+usr.getEmail()
//                render ('<a class="home" href="${createLink(uri: \'/\')}"><g:message code="default.home.label"/></a>')
            }

        return new ModelAndView("/user/peupleBD", [userList: userList, count: count])
    }

}
