package com.menu.appmenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import static com.menu.appmenu.HelloController.leggiFile;

/**
 * Questa classe rappresenta il controller della schermata di visualizzazione dei pazienti
 * @author Giammaria Biffi
 * @version 1.0
 * @see Paziente
 * @see HelloController
 */
public class AppuntamentiController {
    @FXML
    private ListView<String> lista;
    private Vector<Paziente> listaPazienti;
    public void inizializza() throws FileNotFoundException {
        inizializzaLista();
    }

    public void inizializzaLista() throws FileNotFoundException {
        ObservableList<String> items = FXCollections.observableArrayList();
        setListaPazienti();
        for(Paziente paziente : listaPazienti){
            items.add(paziente.getCognome() + " " + paziente.getNome());
        }
        lista.setItems(items);
    }

    public void setListaPazienti() throws FileNotFoundException {
        this.listaPazienti= leggiFile();
        this.listaPazienti = filtraPazienti(listaPazienti);
    }

    public Vector<Paziente> filtraPazienti(Vector<Paziente> plistaPazienti){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar dataOggi = Calendar.getInstance();
        Date data = Calendar.getInstance().getTime();
        String stringaData= sdf.format(data);
        Vector<Paziente> plistaPazienti2 = new Vector<Paziente>();
        plistaPazienti2=plistaPazienti;
        for (int i=0; i< plistaPazienti2.size(); i++){
            String dataAppuntamento = plistaPazienti2.get(i).getDataAppuntamento();
            if(dataAppuntamento.compareTo(stringaData) != 0){
                plistaPazienti.remove(plistaPazienti2.get(i));
            }
        }
        /*for(Paziente paziente : plistaPazienti2){
            String dataAppuntamento = paziente.getDataAppuntamento();
            if(dataAppuntamento.compareTo(stringaData) != 0){
                plistaPazienti.remove(paziente);
            }
        }*/
        return plistaPazienti;
    }
}
