package com.udev.tskmngr

enum Status {
    NON_COMMENCE,
    EN_COURS,
    TERMINE,
    DEPASSE

    static belongsTo = [tache : Tache]
}