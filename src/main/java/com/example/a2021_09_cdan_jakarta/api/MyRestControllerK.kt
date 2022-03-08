package com.example.a2021_09_cdan_jakarta.api

import com.example.a2021_09_cdan_jakarta.model.StudentBean
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlin")
class MyRestControllerK {

    //http://localhost:8080/kotlin/test
    @GetMapping("/test")
    fun testMethode(): String {
        println("/test kotlin")
        return "HelloWorld"
    }

    //http://localhost:8080/kotlin/max?p1=5&p2=12
    @GetMapping("/max")
    fun max(p1: String, p2: String): Int {
        println("/max : p1=$p1 p2=$p2")
        return Math.max(p1.toInt(), p2.toInt())
    }

    //http://localhost:8080/kotlin/testJson
    @GetMapping("/testJson")
    fun testJson(): StudentBean {
        println("/testJson")
        return StudentBean("toto", 10)
    }

    //http://localhost:8080/kotlin/saveStudent
    //Json {"nom": "toto","note": 10 }
    @PostMapping("/saveStudent")
    fun saveStudent(@RequestBody student: StudentBean): StudentBean {
        println("/saveStudent $student")

        student.note++
        return student
    }


}
