package com.example.a2021_09_cdan_jakarta.api;

import com.example.a2021_09_cdan_jakarta.model.CandidatBean;
import com.example.a2021_09_cdan_jakarta.model.CandidatDao;
import com.example.a2021_09_cdan_jakarta.model.CvExperienceBean;
import com.example.a2021_09_cdan_jakarta.model.CvExperienceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


// Page pour l'API
@RestController
@RequestMapping("/api")
public class MyApiController {

    @Autowired
    private CandidatDao candidatDao;
    @Autowired
    private CvExperienceDao cvExperienceDao;



    // Liste des candidats :
    // http://localhost:8083/api/allCandidats

    // Test Api :
    // http://localhost:8083/api/test




    //http://localhost:8083/api/test
    @GetMapping("/test")
    public String testApi() {
        System.out.println("/test");
        return "test";
    }

    // POST : http://localhost:8083/api/addCandidat JSON :
    @PostMapping("/addCandidat")
    public CandidatBean addCandidat(@RequestBody CandidatBean candidatBean, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("/addCandidat" + candidatBean);
        if (candidatBean == null)  {
            System.out.println(" Candidat null");
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Object envoyé invalide");
            return null;
        } else {
            System.out.println(" addCandidat ok");
            return candidatDao.save(candidatBean);
        }
    }

    // POST : http://localhost:8083/api/addExperience/9 JSON :
    @PostMapping("/addExperience/{idCandidat}")
        public CvExperienceBean addExperience(
            @PathVariable("idCandidat") Long idCandidat,
            @RequestBody CvExperienceBean cvExperienceBean,
            HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("/addExperience idCandidat=" + idCandidat);
        System.out.println("/addExperience cvExperienceBean=" + cvExperienceBean);


        // ATTENTION
        ///addCandidatCandidatBean(id=null, nom=, prenom=, date_naiss=, adresse=, email=, telephone=, cv_experiences=null)
        // est consider comme ok soit on check toute les valeurs soit on check apres le save (en bdd on met non-null)



        if (idCandidat != null && candidatDao.findById(idCandidat).isPresent()) {
            cvExperienceBean.setId_candidat(idCandidat);
            System.out.println("/addExperience idCandidat valide ");
            return cvExperienceDao.save(cvExperienceBean);
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "idCandidat invalide");
            return null;
        }
    }

    //http://localhost:8083/api/all
    @GetMapping("/all")
    public List<CandidatBean> getAll() {
        System.out.println("/all");
        return candidatDao.findAll();
    }

    //http://localhost:8083/api/getCandidat/1
    @GetMapping("/getCandidat/{id}")
    public Optional<CandidatBean> getAll(@PathVariable("id") Long id) {
        return candidatDao.findById(id);
    }

}
