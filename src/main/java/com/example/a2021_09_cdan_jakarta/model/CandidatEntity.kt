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
    @Column(name = "id")
    var id: Long? = null,
    var nom: String = "",
    var prenom: String = "",
    var date_naiss: String = "",
    var adresse: String = "",
    var email: String = "",
    var telephone: String = "",


    @OneToMany
    @JoinColumn(name = "id_candidat")
    var cv_experiences: List<CvExperienceBean>? = null,

    @OneToMany
    @JoinColumn(name = "id_candidat")
    var cv_formation: List<CvFormationBean>? = null,

    @OneToMany
    @JoinColumn(name = "id_candidat")
    var cv_competence_principale: List<CvCompetencePrincipaleBean>? = null,

    @OneToMany
    @JoinColumn(name = "id_candidat")
    var cv_competence_secondaire: List<CvCompetenceSecondaireBean>? = null,

    //    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    //    @JoinColumn(name = "id")
    //    var cv_experience: CvExperienceBean? = null
)

@Entity
@Table(name = "cv_experience")
data class CvExperienceBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var id_candidat: Long = 0,
    var titre: String = "",
    var date_debut: String = "",
    var date_fin: String = "",
    var description: String = "",
    var entreprise: String = "",
    var ville: String = "",
    var type_contrat: String = ""
)

@Entity
@Table(name = "cv_formation")
data class CvFormationBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var id_candidat: Long = 0,
    var titre: String = "",
    var date_debut: String = "",
    var date_fin: String = "",
    var ecole: String = "",
    var ville: String = ""
)

@Entity
@Table(name = "cv_competence_principale")
data class CvCompetencePrincipaleBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var id_candidat: Long = 0,
    var titre: String = ""
)

@Entity
@Table(name = "cv_competence_secondaire")
data class CvCompetenceSecondaireBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var id_candidat: Long = 0,
    var titre: String = ""
)

@Repository
interface CandidatDao : JpaRepository<CandidatBean, Long> {}
@Repository
interface CvExperienceDao : JpaRepository<CvExperienceBean, Long> {}
@Repository
interface CvFormationDao : JpaRepository<CvFormationBean, Long> {}
@Repository
interface CvCompetencePrincipaleDao : JpaRepository<CvCompetencePrincipaleBean, Long> {}
@Repository
interface CvCompetenceSecondaireDao : JpaRepository<CvCompetenceSecondaireBean, Long> {}


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

