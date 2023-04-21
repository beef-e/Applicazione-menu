package com.menu.appmenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

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
    public void inizializza(Vector<Paziente> listaPazienti){
        ObservableList<String> items = FXCollections.observableArrayList();
        for(Paziente paziente : listaPazienti){
            items.add(paziente.getCognome() + " " + paziente.getNome());
        }
        //ListView<String> listView = new ListView<String>();
        lista.setItems(items);
    }

    public void setListaPazienti(Vector<Paziente> listaPazienti){
        this.listaPazienti = listaPazienti;
    }
}
