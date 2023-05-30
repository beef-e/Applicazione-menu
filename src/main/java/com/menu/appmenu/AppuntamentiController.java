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
 * @version 1.5
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

    public Vector<Paziente> filtraPazienti(Vector<Paziente> plistaPazienti) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = Calendar.getInstance().getTime();
        String stringaData = sdf.format(data);
        System.out.println(stringaData);
        Vector<Paziente> plistaPazienti2 = new Vector<Paziente>(plistaPazienti);
        for (int i = plistaPazienti2.size() - 1; i >= 0; i--) {
            String dataAppuntamento = plistaPazienti2.get(i).getDataAppuntamento();
            if (!dataAppuntamento.equals(stringaData)) {
                plistaPazienti2.remove(i);
            }
        }
        return plistaPazienti2;
    }

    public void eliminaElemento() {
        ObservableList<String> items = FXCollections.observableArrayList(lista.getItems());
        int selectedIndex = lista.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < items.size()) {
            items.remove(selectedIndex);
        }
        lista.setItems(items);
    }
}
