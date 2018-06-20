package com.udev.tskmngr

class Tache {
    String titre
    String desc
    Date dateCreation
    Date dateDebut
    Date dateFin
    int id
    int duree
    static belongsTo = [user : User]
    static hasOne = [status : Status]

    static constraints = {
    }
}
