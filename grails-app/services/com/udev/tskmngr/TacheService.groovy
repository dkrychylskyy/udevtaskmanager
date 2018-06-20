package com.udev.tskmngr

import grails.gorm.services.Service

@Service(Tache)
interface TacheService {

    Tache get(Serializable id)

    List<Tache> list(Map args)

    Long count()

    void delete(Serializable id)

    Tache save(Tache tache)

}