package com.example.a2021_09_cdan_jakarta.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Repository
interface UserDao : JpaRepository<UserBean, Long> {

    fun findByName(name: String): UserBean?

    fun findByNameContains(name: String): List<UserBean>
}

@Entity
@Table(name = "user")
data class UserBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0, var name: String = "", @Column(name = "password") var psw: String = ""
)
