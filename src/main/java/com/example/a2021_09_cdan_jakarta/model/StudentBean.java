package com.example.a2021_09_cdan_jakarta.model;

public class StudentBean {
    //Attributs
    private String nom;
    private int note;

    //Constructeur (facultatif)

    public StudentBean(String nom, int note) {
        this.nom = nom;
        this.note = note;
    }

    public StudentBean() {
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "nom='" + nom + '\'' +
                ", note=" + note +
                '}';
    }

    //Getter setter

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
