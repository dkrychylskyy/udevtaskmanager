package com.udev.tskmngr

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TacheController {

    TacheService tacheService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tacheService.list(params), model:[tacheCount: tacheService.count()]
    }

    def show(Long id) {
        respond tacheService.get(id)
    }

    def create() {
        respond new Tache(params)
    }

    def save(Tache tache) {
        if (tache == null) {
            notFound()
            return
        }

        try {
            tacheService.save(tache)
        } catch (ValidationException e) {
            respond tache.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tache.label', default: 'Tache'), tache.id])
                redirect tache
            }
            '*' { respond tache, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tacheService.get(id)
    }

    def update(Tache tache) {
        if (tache == null) {
            notFound()
            return
        }

        try {
            tacheService.save(tache)
        } catch (ValidationException e) {
            respond tache.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tache.label', default: 'Tache'), tache.id])
                redirect tache
            }
            '*'{ respond tache, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tacheService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tache.label', default: 'Tache'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tache.label', default: 'Tache'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
