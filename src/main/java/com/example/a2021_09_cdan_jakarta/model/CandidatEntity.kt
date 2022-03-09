package com.example.a2021_09_cdan_jakarta.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*
import javax.transaction.Transactional

//public class CandidatEntity {
//    private val nom: String? = null
//    private val prenom: String? = null
//}

@Entity
@Table(name = "candidat")
data class CandidatBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nom: String = "",
    var prenom: String = "",
)

@Entity
@Table(name = "globalcv")
data class GlobalCvBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var id_candidat: Long = 0,
    var age: Int = 0,
    var adresse: String = "",
    var adresse_email: String = "",
    var telephone: String = "",
)


@Repository
interface CandidatDao : JpaRepository<CandidatBean, Long> {}

@Repository
interface GlobalCvDao : JpaRepository<GlobalCvBean, Long> {}


//    fun getMessage(): String? {
//        return message
//    }


//@Repository
//interface UserDao : JpaRepository<UserBean, Long> {
//
//    fun findByName(name: String): UserBean?
//
//    fun findByNameContains(name: String): List<UserBean>
//}
//
//@Entity
//@Table(name = "user")
//data class UserBean(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long = 0, var name: String = "", @Column(name = "password") var psw: String = ""
//)
//@Entity
//@Table(name = "globalcv")
//data class GlobalCvBean(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = null,
//    var nom: String = "",
//    var prenom: String = ""
//)

