package com.example.a2021_09_cdan_jakarta.web

import com.example.a2021_09_cdan_jakarta.model.CreationBean
import com.example.a2021_09_cdan_jakarta.model.CreationFormBean
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class StoreController {

    val list = arrayListOf(
        CreationBean(
            "Women's dress",
            "https://resize.prod.femina.ladmedia.fr/r/652,/img/var/2021-05/bestimage-00289558-000002.jpg?f468e2d77a",
            "https://resize.prod.femina.ladmedia.fr/r/652,/img/var/2021-05/bestimage-00436434-000083.jpg?e694794580",
            95.95, "12 / 5 / 2021"
        )
    )

    //http://localhost:8080/testStore
    @GetMapping("/testStore")
    fun testHello(model: Model): String {
        println("/testStore")

        model.addAttribute("list", list)
        return "store"
    }

    //http://localhost:8080/admin
    @GetMapping("/admin")
    fun admin(creationFormBean: CreationFormBean): String {
        println("/admin")
        return "adminStore"
    }

    @PostMapping("/adminSubmit")
    fun loginSubmit(creationFormBean: CreationFormBean, model: Model): String {
        println("/adminSubmit : " + creationFormBean.title)

        var erreurMessage = ""
        //Controle
        if (creationFormBean.title.isBlank()) {
            erreurMessage = "Il manque le titre"
        } else if (creationFormBean.url1.isBlank()) {
            erreurMessage = "Il manque l'url1"
        } else if (creationFormBean.password != "1234") {
            erreurMessage = "Mot de passe incorrect"
        }
        if (erreurMessage.isNotBlank()) {
            model.addAttribute("errorMessage", erreurMessage)
            return "adminStore"
        } else {
            //tout va bien on ajoute l'objet et on redirige
            list.add(creationFormBean)

            return "redirect:/testStore"
        }
    }
}
