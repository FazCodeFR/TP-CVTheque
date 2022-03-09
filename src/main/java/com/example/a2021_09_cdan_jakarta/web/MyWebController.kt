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

    @GetMapping("/api/employees/{id}")
    @ResponseBody
    fun getEmployeesById(@PathVariable id: String): String? {
        return "ID: $id"
    }

//    val list = ArrayList<StudentBean>()

//    init {
//        list.add(StudentBean("Toto", 12))
//        list.add(StudentBean("Tata", 12))
//        list.add(StudentBean("Toto", 12))
//        list.add(StudentBean("Tata", 14))
//        list.add(StudentBean("Bobby", 14))
//    }
//



//
//    //http://localhost:8080/add?nom=toto&note=15
//    @GetMapping("/add")
//    fun add(nom: String, note: Int, model: Model): String {
//        println("/add nom=$nom, note=$note")
//        //Nom du fichier HTML que l'on souhaite afficher
//        val student = StudentBean(nom, note)
//        list.add(student)
//
//        model.addAttribute("message", "Bonjour ")
//        model.addAttribute("student", student)
//
//        model.addAttribute("listStudent", list)
//
//        return "welcome"
//    }
//
//    //http://localhost:8080/filter?nom=toto&note=15
//    @GetMapping("/filter")
//    fun filter(@RequestParam(defaultValue = "") nom: String, @RequestParam(required = false) note: Int?, model: Model): String {
//        println("/filter nom=$nom, note=$note")
//
//        //Nom du fichier HTML que l'on souhaite afficher
//        val filterList = list.filter { (nom == "" || it.nom.equals(nom, true)) && (note == null || note == it.note) }
//
//        model.addAttribute("message", "Filtre : nom=$nom, note=$note ")
//        model.addAttribute("student", null)
//
//        model.addAttribute("listStudent", filterList)
//
//        return "welcome"
//    }
//


    //    //http://localhost:8080/tesjpa
//    @GetMapping("/tesjpa")
//    fun tesjpa(): MutableList<TeacherBean> {
//        println("/tesjpa")
//        val teacher = TeacherBean(0, "Tata")
//
//        teacherDao.save(teacher)
//
//        return teacherDao.findAll()
//    }




}
