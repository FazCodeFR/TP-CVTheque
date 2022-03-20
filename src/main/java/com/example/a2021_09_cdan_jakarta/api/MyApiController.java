package com.example.a2021_09_cdan_jakarta.api;

import com.example.a2021_09_cdan_jakarta.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


// Page pour l'API
@RestController
@RequestMapping("/api")
/**
 * A controller that exposes a REST API to the MyApiService.
 */
public class MyApiController {

    @Autowired
    private CandidatDao candidatDao;
    @Autowired
    private CvExperienceDao cvExperienceDao;

    @Autowired
    private CvFormationDao cvFormationDao;

    // GET Liste des candidats :
    // http://localhost:8083/api/all

    // GET Test Api :
    // http://localhost:8083/api/test

    // GET Candidat par id :
    // http://localhost:8083/api/candidat/1



    //http://localhost:8083/api/test
    /**
    * `@GetMapping("/test")` is a method annotation that tells Spring MVC to map this method to the URL
    * "/test"
    * 
    * @return The return type is String.
    */
    @GetMapping("/test")
    public String testApi() {
        System.out.println("/test");
        return "test";
    }

    // POST : http://localhost:8083/api/addCandidat
    // JSON : {
    //    "nom": "Yess",
    //    "prenom": "Paullll",
    //    "date_naiss": "05/01/2000",
    //    "adresse": "Rue du Superprof",
    //    "email": "leo@gmail.com",
    //    "telephone": "0671230605"
    //}
    /**
    * @param candidatBean The object that will be saved in the database.
    * @param httpServletResponse The response object that the servlet uses to send the response to the
    * client.
    * @return candidatBean or null
    */
    @PostMapping("/addCandidat")
    public CandidatBean addCandidat(@RequestBody CandidatBean candidatBean, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("/addCandidat" + candidatBean);
        if (candidatBean == null)  {
            System.out.println(" Candidat null");
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Object envoyé invalide");
            return null;
        } else {
            if (candidatBean.IsValide(candidatBean, httpServletResponse)){
                System.out.println(" Candidat valide");
                return candidatDao.save(candidatBean);
            }
            else {
                System.out.println("Candidat invalide");
                return null;
            }
        }
    }

    // POST : http://localhost:8083/api/addExperience/2 JSON :

   /**
    * Add a new experience to a candidate
    * 
    * @param idCandidat the id of the candidate to whom the experience will be added.
    * @param cvExperienceBean the object to be saved
    * @return The CvExperienceBean or null is returned.
    */
    @PostMapping("/addExperience/{idCandidat}")
        public CvExperienceBean addExperience(
            @PathVariable("idCandidat") Long idCandidat,
            @RequestBody CvExperienceBean cvExperienceBean,
            HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("/addExperience idCandidat=" + idCandidat);
        System.out.println("/addExperience cvExperienceBean=" + cvExperienceBean);

        if (cvExperienceBean == null || cvExperienceBean.toString().trim() == "" || cvExperienceBean.toString().trim() == "{}" || cvExperienceBean.toString().trim() == "null")  {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "object invalide");
            return null;
        }
        if (idCandidat != null && candidatDao.findById(idCandidat).isPresent()) {
            cvExperienceBean.setId_candidat(idCandidat);
            System.out.println("/addExperience idCandidat valide ");

            if (cvExperienceBean.IsValid(cvExperienceBean, httpServletResponse)){
                return cvExperienceDao.save(cvExperienceBean);
            } else {
                System.out.println("/addExperience cvExperienceBean invalide ");
                return null;
            }
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "idCandidat invalide");
            return null;
        }
    }

    // POST : http://localhost:8083/api/addFormation/2
    // JSON :
    // {
    //    "titre": "mon ecole",
    //    "date_debut": "01/02/2022",
    //    "date_fin": "01/03/2022",
    //    "ecole": "IPI",
    //    "ville": "Toulouse"
    //}
   /**
    * Add a new formation to the database
    * 
    * @param idCandidat the id of the candidate
    * @param cvFormationBean the object that will be saved in the database.
    * @return CvFormationBean or null is returned.
    */
    @PostMapping("/addFormation/{idCandidat}")
    public CvFormationBean addFormation(
            @PathVariable("idCandidat") Long idCandidat,
            @RequestBody CvFormationBean cvFormationBean,
            HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("/addFormation idCandidat=" + idCandidat);
        System.out.println("/addFormation cvExperienceBean=" + cvFormationBean);

        if (cvFormationBean == null || cvFormationBean.toString().trim() == "" || cvFormationBean.toString().trim() == "{}" || cvFormationBean.toString().trim() == "null")  {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "object invalide");
            return null;
        }

        if (idCandidat != null && candidatDao.findById(idCandidat).isPresent()) {
            cvFormationBean.setId_candidat(idCandidat);
            System.out.println("/addFormation idCandidat valide ");

            if (cvFormationBean.IsValid(cvFormationBean, httpServletResponse)){
                return cvFormationDao.save(cvFormationBean);
            } else {
                System.out.println("/addFormation cvExperienceBean invalide ");
                return null;
            }

        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "idCandidat invalide");
            return null;
        }
    }



    //http://localhost:8083/api/all
    /**
    * Get all CandidatBeans
    * @return List<CandidatBean>
    */
    @GetMapping("/all")
    public List<CandidatBean> getAll() {
        System.out.println("/all");
        return candidatDao.findAll();
    }

    //http://localhost:8083/api/getCandidat/1
    /**
    * Get a single CandidatBean by id
    * 
    * @param id The id of the candidate we want to retrieve.
    * @return CandidatBean
    */
    @GetMapping("/getCandidat/{id}")
    public Optional<CandidatBean> getAll(@PathVariable("id") Long id) {
        return candidatDao.findById(id);
    }

}
