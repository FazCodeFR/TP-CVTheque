package com.example.a2021_09_cdan_jakarta.api

import com.example.a2021_09_cdan_jakarta.model.UserBean
import com.example.a2021_09_cdan_jakarta.model.UserDao
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/userapi")
class UserAPI(val userDao: UserDao) {

    //http://localhost:8080/userapi/login
    @PostMapping("/login")
    fun login(@RequestBody user: UserBean, httpServletResponse: HttpServletResponse) {
        println("/login")

        if (user.name.isBlank() || user.psw.isBlank()) {
            httpServletResponse.status = 203
            return
        }

        val userBdd = userDao.findByName(user.name)
        if (userBdd == null) {
            //insert
            userDao.save(user)
            httpServletResponse.status = 201
        }
        //test
        else if (userBdd.psw == user.psw) {
            httpServletResponse.status = 202
        } else {
            httpServletResponse.status = 204
        }
    }

    //http://localhost:8080/userapi/find
    @GetMapping("/find")
    fun find(@RequestParam(defaultValue = "", required = false) name: String, httpServletResponse: HttpServletResponse): List<UserBean>? {
        println("/find name=$name")

        if (name.isBlank()) {
            httpServletResponse.status = 203
            return null
        }

        val list = userDao.findByNameContains(name)

        if (list.isEmpty()) {
            httpServletResponse.status = 201
            return null
        } else {
            return list.map { UserBean(name = it.name) }
        }
    }
}
