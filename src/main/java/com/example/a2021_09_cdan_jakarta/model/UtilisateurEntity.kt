package com.example.a2021_09_cdan_jakarta.model

import javax.persistence.*

@Entity
@Table(name = "utilisateur")
data class UtilisateurBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nom: String = "",
    var prenom: String = "",
)