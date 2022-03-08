package com.example.a2021_09_cdan_jakarta.web

import org.springframework.stereotype.Controller

@Controller
class MyWebController {

//    val list = ArrayList<StudentBean>()

//    init {
//        list.add(StudentBean("Toto", 12))
//        list.add(StudentBean("Tata", 12))
//        list.add(StudentBean("Toto", 12))
//        list.add(StudentBean("Tata", 14))
//        list.add(StudentBean("Bobby", 14))
//    }
//
//    //http://localhost:8080/hello
//    @GetMapping("/hello")
//    fun testHello(model: Model, session: HttpSession): String {
//        println("/hello : ${session.id}")
//        //Nom du fichier HTML que l'on souhaite afficher
//
//        model.addAttribute("message", "Bonjour ")
//        model.addAttribute("student", null) //StudentBean("Toto", 12))
//
//        val list = arrayListOf(StudentBean("Bob", 12), StudentBean("Bobby", 14))
//        model.addAttribute("listStudent", list)
//
//        return "welcome"
//    }
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
