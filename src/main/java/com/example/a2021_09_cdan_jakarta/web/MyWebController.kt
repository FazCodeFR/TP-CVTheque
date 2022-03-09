package com.example.a2021_09_cdan_jakarta.web

import com.example.a2021_09_cdan_jakarta.model.CandidatBean
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpSession

@Controller
class MyWebController {

    //http://localhost:8080/candidats
    @GetMapping("/")
    fun listeCandidat(model: Model, session: HttpSession): String {
        println("liste des candidats")
        val list = arrayListOf(CandidatBean(1, "florian", "alcaraz"), CandidatBean(2, "florian", "alcaraz"))
        model.addAttribute("listeCandidat", list)
        return "index"
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
