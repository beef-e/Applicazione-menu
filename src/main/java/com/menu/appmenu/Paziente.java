package com.menu.appmenu;

/**
 * Questa classe rappresenta un paziente
 * @author Giammaria Biffi
 * @version 1.0
 */
public class Paziente {
    /**
     * Cognome è una Stringa che rappresenta il cognome del paziente
     */
    String cognome;

    /**
     * Nome è una Stringa che rappresenta il nome del paziente
     */
    String nome;

    /**
     * Cf è una Stringa che rappresenta il codice fiscale del paziente
     */
    String cf;

    /**
     * Telefono è una Stringa che rappresenta il numero di telefono del paziente
     */
    String telefono;

    /**
     * Patologia è una Stringa che rappresenta la patologia del paziente
     */
    String patologia;

    /**
     * Costruttore della classe Paziente
     * @param cognome Cognome del paziente
     * @param nome Nome del paziente
     * @param cf Codice fiscale del paziente
     * @param telefono Numero di telefono del paziente
     * @param patologia Patologia del paziente
     */
    public Paziente(String cognome, String nome, String cf, String telefono, String patologia){
        this.cognome = cognome;
        this.nome = nome;
        this.cf = cf;
        this.telefono = telefono;
        this.patologia = patologia;
    }

    /**
     * Metodo che restituisce una stringa contenente il cognome del paziente
     * @return Stringa contenente il cognome del paziente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo che imposta il cognome del paziente
     * @param cognome Stringa contenente il cognome del paziente
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Metodo che restituisce una stringa contenente il nome del paziente
     * @return nome Stringa contenente il nome del paziente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo che imposta il nome del paziente
     * @param nome Stringa contenente il nome del paziente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo che restituisce una stringa contenente il codice fiscale del paziente
     * @return Stringa contenente il codice fiscale del paziente
     */
    public String getCf() {
        return cf;
    }

    /**
     * Metodo che imposta il codice fiscale del paziente
     * @param cf Stringa contenente il codice fiscale del paziente
     */
    public void setCf(String cf) {
        this.cf = cf;
    }

    /**
     * Metodo che restituisce una stringa contenente il numero di telefono del paziente
     * @return Stringa contenente il numero di telefono del paziente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo che imposta il numero di telefono del paziente
     * @param telefono Stringa contenente il numero di telefono del paziente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo che restituisce una stringa contenente la patologia del paziente
     * @return Stringa contenente la patologia del paziente
     */
    public String getPatologia() {
        return patologia;
    }

    /**
     * Metodo che imposta la patologia del paziente
     * @param patologia Stringa contenente la patologia del paziente
     */
    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }
}
