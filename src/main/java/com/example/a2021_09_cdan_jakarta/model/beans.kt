package com.example.a2021_09_cdan_jakarta.model

import javax.persistence.*


open class CreationBean(
    var title: String = "",
    var url1: String = "",
    var url2: String = "",
    var price: Double? = null,
    var date: String = ""
)

data class CreationFormBean(var password: String? = "") : CreationBean()

@Entity
@Table(name = "teacher")
data class TeacherBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String = "",
    var password: String = ""
)
