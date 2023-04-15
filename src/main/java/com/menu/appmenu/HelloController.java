package com.menu.appmenu;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

public class HelloController {

	private Vector<Paziente> listapazienti = new Vector<Paziente>();

	@FXML
	private AnchorPane registrazionePanel;

	@FXML private TextField txtCognome;
	@FXML private TextField txtNome;
	@FXML private TextField txtCF;
	@FXML private TextField txtTelefono;
	@FXML private TextArea txtPatologia;


	@FXML
	protected void registrazione() throws IOException{
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Registrazione-view.fxml")));
		Stage stage = new Stage();
		stage.setTitle("Registrazione");
		stage.setScene(new Scene(root, 800, 600));
		stage.setResizable(false);
		stage.show();
	}

	@FXML
	protected void resetRegistrazione(){
		txtCognome.setText("");
		txtNome.setText("");
		txtPatologia.setText("");
		txtTelefono.setText("");
		txtCF.setText("");
	}

	@FXML
	protected void salvaRegistrazione(){
		if(txtCognome.getText().isEmpty() || txtNome.getText().isEmpty() || txtCF.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtPatologia.getText().isEmpty()){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Errore");
			alert.setHeaderText("Errore nella registrazione");
			alert.setContentText("Compila tutti i campi");
			alert.showAndWait();
		}else{
			listapazienti.add(new Paziente(txtCognome.getText(), txtNome.getText(), txtCF.getText(), txtTelefono.getText(), txtPatologia.getText()));
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Registrazione avvenuta con successo");
			txtCognome.setText("");
			txtNome.setText("");
			txtPatologia.setText("");
			txtTelefono.setText("");
			txtCF.setText("");
		}
	}

	@FXML
	protected void esci(){
		Stage stage;
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Esci dalla registrazione");
		alert.setHeaderText("Stai per uscire dalla finestra di registrazione");
		alert.setContentText("Vuoi salvare i dati inseriti prima di uscire?");

		if(alert.showAndWait().get()== ButtonType.OK){
			stage = (Stage) registrazionePanel.getScene().getWindow();

			stage.close();
		}
	}

	@FXML
	protected void visualizzazione() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Visualizza-view.fxml"));
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.setScene(new Scene(loader.load(), 800, 600));
		stage.setTitle("Visualizzazione");
		stage.setResizable(false);
		visualizzaController controller = loader.getController();
		controller.inizializza(listapazienti);
		stage.show();
	}


}

