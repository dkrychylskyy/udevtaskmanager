package com.udev.tskmngr

import grails.gorm.transactions.Transactional

@Transactional
class CreationDatesService {

    def dateCreator(int num) {
        System.out.println(num)
    }
}
