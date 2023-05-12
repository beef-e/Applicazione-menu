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

    @FXML private ListView<String> lista;
    private Vector<Paziente> listaPazienti;

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //crea un observable list che è una lista che si aggiorna automaticamente
        ObservableList<String> pazienti = FXCollections.observableArrayList();
        //cicla la lista dei pazienti e aggiunge i pazienti alla lista

        for(int i=0; i < listaPazienti.size(); i++){
            pazienti.add(listaPazienti.get(i).getCognome() + " " + listaPazienti.get(i).getNome());
        }

        for(Paziente paziente : listaPazienti){
            pazienti.add(paziente.getCognome() + " " + paziente.getNome());
        }
        //setta la lista
        lista.setItems(pazienti);
    }*/
    public void inizializza() throws FileNotFoundException {
        ObservableList<String> items = FXCollections.observableArrayList();
        setListaPazienti();
        for(Paziente paziente : listaPazienti){
            items.add(paziente.getCognome() + " " + paziente.getNome());
        }
        //ListView<String> listView = new ListView<String>();
        lista.setItems(items);
    }

    public void setListaPazienti() throws FileNotFoundException {
        this.listaPazienti= leggiFile();
        System.out.println(listaPazienti.size());
    }
}
