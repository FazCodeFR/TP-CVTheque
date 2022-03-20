package com.example.a2021_09_cdan_jakarta.web

import com.example.a2021_09_cdan_jakarta.model.CandidatBean
import com.example.a2021_09_cdan_jakarta.model.CandidatDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession


@Controller
class MyWebController {

    @Autowired
    private val candidatDao: CandidatDao? = null

    //http://localhost:8080/candidats
    @GetMapping("/")
    fun listeCandidat(model: Model, session: HttpSession): String {
        println("liste des candidats")

        val candidats = candidatDao!!.findAll()
        model.addAttribute("listeCandidat", candidats)
        return "index"
    }

    //http://localhost:8080/cv?id=16
    @GetMapping("/candidat/{id}")
    fun cvCandidat(
        @PathVariable id : Long,
        model: Model,
        httpServletResponse: HttpServletResponse
    ): String?
    {
        var candidat = candidatDao?.findByIdOrNull(id)
        println("CV du candidat "+ candidat)

        if (candidat != null) {
            model.addAttribute("candidat", candidat)
            return "cv"
        }
        httpServletResponse.status = HttpServletResponse.SC_NOT_FOUND
        return null
    }

    @GetMapping("login")
    fun login(model: Model): String {
        println("login")
        return "login"
    }



}
