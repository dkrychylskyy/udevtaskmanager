package com.udev.tskmngr

class User {
    String nom

    static hasMany = [taches : Tache]

    static constraints = {
    }
}
