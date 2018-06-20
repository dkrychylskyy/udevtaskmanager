package com.udev.tskmngr

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TacheServiceSpec extends Specification {

    TacheService tacheService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tache(...).save(flush: true, failOnError: true)
        //new Tache(...).save(flush: true, failOnError: true)
        //Tache tache = new Tache(...).save(flush: true, failOnError: true)
        //new Tache(...).save(flush: true, failOnError: true)
        //new Tache(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tache.id
    }

    void "test get"() {
        setupData()

        expect:
        tacheService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tache> tacheList = tacheService.list(max: 2, offset: 2)

        then:
        tacheList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tacheService.count() == 5
    }

    void "test delete"() {
        Long tacheId = setupData()

        expect:
        tacheService.count() == 5

        when:
        tacheService.delete(tacheId)
        sessionFactory.currentSession.flush()

        then:
        tacheService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tache tache = new Tache()
        tacheService.save(tache)

        then:
        tache.id != null
    }
}
