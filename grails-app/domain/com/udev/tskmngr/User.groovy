package com.udev.tskmngr

class User {
    String nom
    String prenom
    String email
    String mdp

    static hasMany = [taches : Tache]

    static constraints = {
        email email: true
    }
}
