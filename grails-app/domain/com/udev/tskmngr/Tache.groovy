package com.udev.tskmngr

class Tache {
    String titre

    static belongsTo = [user : User]

    static constraints = {
    }
}
