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
class CandidatBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nom: String = "",
    var prenom: String = "",
)

@Entity
@Table(name = "gloabalcv")
data class GloabalCvBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var age: Int = 0,
    var adresse: String = "",
    var adresseEmail: String = "",
    var telephone: String = "",
)


@Repository
interface CandidatDao : JpaRepository<CandidatBean, Long> {

    //fun findByName(name: String): CandidatBean?

   // fun findByNameContains(name: String): List<CandidatBean>
}


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
//@Table(name = "gloabalcv")
//data class GloabalCvBean(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = null,
//    var nom: String = "",
//    var prenom: String = ""
//)

