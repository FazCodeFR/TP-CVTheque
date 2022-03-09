package com.example.a2021_09_cdan_jakarta.api;

import com.example.a2021_09_cdan_jakarta.model.CandidatBean;
import com.example.a2021_09_cdan_jakarta.model.CandidatDao;
import com.example.a2021_09_cdan_jakarta.model.CvExperienceBean;
import com.example.a2021_09_cdan_jakarta.model.CvExperienceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // POST : http://localhost:8083/api/addCandidat JSON : { "nom": "Yess", "prenom": "Paullll"}
    @PostMapping("/addCandidat")
    public CandidatBean addCandidat(@RequestBody CandidatBean candidatBean) {
        System.out.println("/addCandidat");
        return candidatDao.save(candidatBean);
    }

    // POST : http://localhost:8083/api/addCandidatInfo/9 JSON : { "nom": "Yess", "prenom": "Paullll"}
    @PostMapping("/addCandidatInfo/{idCandidat}")
    public CvExperienceBean addCandidatInfo(
            @PathVariable("idCandidat") Long idCandidat,
            @RequestBody CvExperienceBean cvExperienceBean)
    {
//        cv.setId_candidat(idCandidat);
        System.out.println("/addCandidatInfo idCandidat=" + idCandidat);
        System.out.println("/addCandidatInfo cvExperienceBean=" + cvExperienceBean);
        return cvExperienceDao.save(cvExperienceBean);
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
