package com.example.a2021_09_cdan_jakarta.web

import com.example.a2021_09_cdan_jakarta.model.UserBean
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController {

    val userList = ArrayList<UserBean>()

    //http://localhost:8080/login
    @GetMapping("/login")
    fun login(userBean: UserBean): String {
        println("/login")
        return "login"
    }

    @PostMapping("/loginSubmit")
    fun loginSubmit(userBean: UserBean, model: Model): String {
        println("/loginSubmit")
        val user = userList.firstOrNull { userBean.name == it.name }

        if (user != null) {
            if (user.psw != userBean.psw) {
                model.addAttribute("errorMessage", "Mot de passe incorrecte")
                return "login"
            }
        } else {
            userList.add(userBean)
        }

        model.addAttribute("userList", userList)

        return "index"
    }

    /* -------------------------------- */
    // Exercice sur Le jar
    /* -------------------------------- */
}
