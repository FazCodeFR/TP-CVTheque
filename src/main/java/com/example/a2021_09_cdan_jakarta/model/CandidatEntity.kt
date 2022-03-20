package com.example.a2021_09_cdan_jakarta.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*
import javax.servlet.http.HttpServletResponse

//public class CandidatEntity {
//    private val nom: String? = null
//    private val prenom: String? = null
//}


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
) {
    fun IsValid(cvExperienceBean: CvExperienceBean, httpServletResponse: HttpServletResponse): Boolean {

        var erreurTexte = ""

        if (cvExperienceBean.titre.trim().isNullOrEmpty()) {
            erreurTexte += "Le titre est obligatoire. "
        }
        if (cvExperienceBean.date_debut.trim().isNullOrEmpty()) {
            erreurTexte += "La date de début est obligatoire. "
        }
        if (cvExperienceBean.date_fin.trim().isNullOrEmpty()) {
            erreurTexte += "La date de fin est obligatoire. "
        }
        if (cvExperienceBean.description.trim().isNullOrEmpty()) {
            erreurTexte += "La description est obligatoire. "
        }
        if (cvExperienceBean.entreprise.trim().isNullOrEmpty()) {
            erreurTexte += "L'entreprise est obligatoire. "
        }
        if (cvExperienceBean.ville.trim().isNullOrEmpty()) {
            erreurTexte += "La ville est obligatoire. "
        }
        if (cvExperienceBean.type_contrat.trim().isNullOrEmpty()) {
            erreurTexte += "Le type de contrat est obligatoire. "
        }
        return if (erreurTexte.isNotEmpty()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, erreurTexte)
            false
        } else{
            true
        }

    }
}


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
){
    fun IsValide(candidatBean: CandidatBean, httpServletResponse: HttpServletResponse): Boolean {

        var erreurTexte = ""

        if (candidatBean.nom.trim().isNullOrEmpty()) {
            erreurTexte += "Le nom est obligatoire. "
        }
        if (candidatBean.prenom.trim().isNullOrEmpty()) {
            erreurTexte += "Le prenom est obligatoire. "
        }
        if (candidatBean.date_naiss.trim().isNullOrEmpty()) {
            erreurTexte += "La date de naissance est obligatoire. "
        }
        if (candidatBean.adresse.trim().isNullOrEmpty()) {
            erreurTexte += "L'adresse est obligatoire. "
        }
        if (candidatBean.email.trim().isNullOrEmpty()) {
            erreurTexte += "L'email est obligatoire. "
        }
        if (candidatBean.telephone.trim().isNullOrEmpty()) {
            erreurTexte += "Le téléphone est obligatoire. "
        }
        return if (erreurTexte.isNotEmpty()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, erreurTexte)
            false
        } else{
            true
        }

    }
}



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
{
    fun IsValid(cvFormationBean: CvFormationBean, httpServletResponse: HttpServletResponse): Boolean {

        var erreurTexte = ""

        if (cvFormationBean.titre.trim().isNullOrEmpty()) {
            erreurTexte += "Le titre est obligatoire. "
        }
        if (cvFormationBean.date_debut.trim().isNullOrEmpty()) {
            erreurTexte += "La date de début est obligatoire. "
        }
        if (cvFormationBean.date_fin.trim().isNullOrEmpty()) {
            erreurTexte += "La date de fin est obligatoire. "
        }
        if (cvFormationBean.ecole.trim().isNullOrEmpty()) {
            erreurTexte += "L'école est obligatoire. "
        }
        if (cvFormationBean.ville.trim().isNullOrEmpty()) {
            erreurTexte += "La ville est obligatoire. "
        }

        return if (erreurTexte.isNotEmpty()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, erreurTexte)
            false
        } else {
            true
        }
    }
}

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
