package com.menu.appmenu;

public class Paziente {
    String cognome;
    String nome;
    String cf;
    String telefono;
    String patologia;

    //create a constructor
    public Paziente(String cognome, String nome, String cf, String telefono, String patologia){
        this.cognome = cognome;
        this.nome = nome;
        this.cf = cf;
        this.telefono = telefono;
        this.patologia = patologia;
    }

    //crea i metodi get e set di tutti gli attributi
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }
}
