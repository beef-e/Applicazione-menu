package com.menu.appmenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class visualizzaController implements Initializable{

    @FXML private ListView<String> lista;
    private Vector<Paziente> listaPazienti;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //crea un observable list che è una lista che si aggiorna automaticamente
        ObservableList<String> pazienti = FXCollections.observableArrayList();
        //cicla la lista dei pazienti e aggiunge i pazienti alla lista

        for(Paziente paziente : listaPazienti){
            pazienti.add(paziente.getCognome() + " " + paziente.getNome());
        }
        //setta la lista
        lista.setItems(pazienti);
    }

    public void setListaPazienti(Vector<Paziente> listaPazienti){
        this.listaPazienti = listaPazienti;
    }
}
