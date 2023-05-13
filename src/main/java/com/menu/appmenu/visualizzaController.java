package com.menu.appmenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.util.Vector;

import static com.menu.appmenu.HelloController.leggiFile;

/**
 * Questa classe rappresenta il controller della schermata di visualizzazione dei pazienti
 * @author Giammaria Biffi
 * @version 1.0
 * @see Paziente
 * @see HelloController
 */
public class visualizzaController{

    /**
     * Questa variabile rappresenta la lista dei pazienti nel file FX
     */
    @FXML private ListView<String> lista;

    /**
     * Questa variabile rappresenta l'effettiva lista dei pazienti nel file
     */
    private Vector<Paziente> listaPazienti;

    /**
     * Questo metodo inizializza la lista dei pazienti
     * */
    public void inizializza() throws FileNotFoundException {
        ObservableList<String> items = FXCollections.observableArrayList();
        setListaPazienti();
        for(Paziente paziente : listaPazienti){
            items.add(paziente.getCognome() + " " + paziente.getNome());
        }
        //ListView<String> listView = new ListView<String>();
        lista.setItems(items);
    }

    /**
     * Questo metodo legge il file listaPazienti.txt e ne salva il valore in listaPazienti
     * */
    public void setListaPazienti() throws FileNotFoundException {
        this.listaPazienti= leggiFile();
        System.out.println(listaPazienti.size());
    }
}
