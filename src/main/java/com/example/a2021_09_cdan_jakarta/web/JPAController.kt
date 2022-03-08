package com.example.a2021_09_cdan_jakarta.web

import com.example.a2021_09_cdan_jakarta.model.TeacherBean
import com.example.a2021_09_cdan_jakarta.model.TeacherDao
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JPARestController(val teacherDao: TeacherDao) {

    //http://localhost:8080/tesjpa
    @GetMapping("/tesjpa")
    fun tesjpa(): MutableList<TeacherBean> {
        println("/tesjpa")
        val teacher = TeacherBean(0, "Tata")

        teacherDao.save(teacher)

        return teacherDao.findAll()
    }
}
