package com.example.a2021_09_cdan_jakarta.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface TeacherDao : JpaRepository<TeacherBean, Long> {

    @Transactional
    fun deleteByName(name: String): Int
}
