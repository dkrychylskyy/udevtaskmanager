package com.udev.tskmngr

class User {
    String nom
    String prenom

    static hasMany = [taches : Tache]

    static constraints = {
    }
}
