package com.example.a2021_09_cdan_jakarta.api;

import com.example.a2021_09_cdan_jakarta.model.CandidatBean;
import com.example.a2021_09_cdan_jakarta.model.CandidatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// Page pour l'API
@RestController
@RequestMapping("/api")
public class MyApiController {

//    private ArrayList<MessageBean> listMessages = new ArrayList<>();

    @Autowired
    private CandidatDao candidatDao ;


    //http://localhost:8080/api/test
    @GetMapping("/test")
    public String testMethode() {
        System.out.println("/test");
        CandidatBean candidatBean = new CandidatBean();
        candidatBean.setNom("Dupont");
        candidatBean.setPrenom("Jean");
        return candidatDao.save(candidatBean).toString();
    }

//    //http://localhost:8080/testJson
//    @GetMapping("/testJson")
//    public StudentBean testJson() {
//        System.out.println("/testJson");
//        StudentBean student = new StudentBean("toto", 10);
//        return student;
//    }
//
//    //http://localhost:8080/testJsonWithParam?nom=bob&note=12
////Avec nom facultatif et note obligatoire
//    @GetMapping("/testJsonWithParam")
//    public StudentBean testJsonWithParam(
//            @RequestParam(value = "nom", defaultValue = "toto") String p1,
//            Integer note) {
//
//        System.out.println("/testJsonWithParam : p1=" + p1 + " note=" + note);
//
//        return new StudentBean(p1, note);
//    }
//
//
//    //http://localhost:8080/max?p1=5&p2=12
//    @GetMapping("/max")
//    public Integer max(String p1, String p2) {
//
//        System.out.println("/max : p1=" + p1 + " p2=" + p2);
//
//        Integer p1Int = null;
//        try {
//            p1Int = Integer.parseInt(p1);
//        } catch (NumberFormatException e) {
//
//        }
//        Integer p2Int = null;
//        try {
//            p2Int = Integer.parseInt(p2);
//        } catch (NumberFormatException e) {
//
//        }
//        if (p1Int == null) return p2Int;
//        if (p2Int == null) return p1Int;
//
//        return Math.max(p1Int, p2Int);
//    }
//
//    //http://localhost:8080/maxSimple?p1=5&p2=12
//    @GetMapping("/maxSimple")
//    public Integer maxSimple(int p1, int p2) {
//        System.out.println("/max : p1=" + p1 + " p2=" + p2);
//        return Math.max(p1, p2);
//    }
//
//
//    //http://localhost:8080/boulangerie?nbC=5&nbS=12
//    @GetMapping("/boulangerie")
//    public String boulangerie(@RequestParam(defaultValue = "0") int nbC, @RequestParam(defaultValue = "0") int nbS) {
//        System.out.println("/boulangerie : nbC=" + nbC + " nbS=" + nbS);
//
//        double prixCroissant = 0.95;
//        int prixSand = 4;
//
//        return ("" + nbC * prixCroissant + nbS * prixSand).replace(".", "€");
//    }
//
//    /* -------------------------------- */
//    // Exo Message
//    /* -------------------------------- */
//
//    //http://localhost:8080/saveMessage
//    //json a envoyer : { "message" : "hello", "pseudo":"toto"}
//    @PostMapping("/saveMessage")
//    public ArrayList<MessageBean> saveMessage(@RequestBody MessageBean message) {
//        System.out.println("/saveMessage : message=" + message.getMessage() + " pseudo=" + message.getPseudo());
//
//        listMessages.add(message);
//
//        return listMessages;
//    }
//
//
//    //http://localhost:8080/allMessages
//    @GetMapping("/allMessages")
//    public List<MessageBean> getMessages(String filter, String pseudo) {
//        System.out.println("/allMessages");
//
//        ArrayList<MessageBean> temp = new ArrayList<>();
//
//        for (MessageBean m : listMessages) {
//            if (filter == null || (m.getMessage() != null && m.getMessage().contains(filter))) {
//                if (pseudo == null || m.getPseudo() != null && m.getPseudo().equals(pseudo)) {
//                    temp.add(m);
//                }
//            }
//        }
//
//        if (temp.isEmpty()) {
//            return new ArrayList<>();
//        }
//        return temp.subList(Math.max(0, temp.size() - 10), temp.size() - 1);
//    }
}
