package com.menu.appmenu;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

/**
 * Questa classe rappresenta il controller della schermata principale dell'applicazione.
 * Per ragioni organizzative, viene incluso anche il controller della schermata di Registrazione dei pazienti
 * @author Giammaria Biffi
 * @version 1.0
 * @see Paziente
 */
public class HelloController {

	private static Vector<Paziente> listapazienti = new Vector<Paziente>();

	@FXML
	private AnchorPane registrazionePanel;

	@FXML private TextField txtCognome;
	@FXML private TextField txtNome;
	@FXML private TextField txtCF;
	@FXML private TextField txtTelefono;
	@FXML private TextArea txtPatologia;

	/**
	 * Metodo che crea il file listaPazienti.txt
	 */
	public void creaFile(){
		try{
			File file = new File("listaPazienti.txt");
			if(file.createNewFile()){
				System.out.println("File created: " + file.getName());
			}else{
				System.out.println("File already exists.");
			}
		}catch(IOException e){
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo che legge il file listaPazienti.txt, le cui stringhe hanno separatore il carattere ","
	 */
	public static Vector<Paziente> leggiFile() throws FileNotFoundException {
		File file= new File("/home/beef_e/IdeaProjects/Applicazione-menu/listaPazienti.txt");
		Scanner reader = new Scanner(file);
		Vector <Paziente> vettore = new Vector<>();
		while(reader.hasNextLine()){
			String data = reader.nextLine();
			String [] dataVero=data.split(",");
			vettore.add(new Paziente(dataVero[0],dataVero[1],dataVero[2],dataVero[3],dataVero[4]));

			//listapazienti.add(pazientino);

			//listapazienti.add(new Paziente(paziente[0], paziente[1], paziente[2], paziente[3], paziente[4]));
		}
		reader.close();
		return vettore;
	}

	/**
	 * Metodo che scrive in append sul file listaPazienti.txt
	 * @param Stringa Contenente le informazioni sul paziente, già concatenate
	 * */
	public void scriviFile(String Stringa){
		try{
			FileWriter fileWriter = new FileWriter("listaPazienti.txt", true);
			fileWriter.write(Stringa);
			fileWriter.close();
		}catch(IOException e){
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo per la concatenazione dei dati dei pazienti
	 * @param paziente Paziente con informazioni da concatenare
	 * @return Stringa contenente le informazioni concatenate
	 * */
	public String concatenaStringa(Paziente paziente){
		String Stringa="";
		Stringa+=paziente.getCognome()+","+paziente.getNome()+","+paziente.getCf()+","+paziente.getTelefono()+","+paziente.getPatologia()+"\n";
		return Stringa;
	}


	public void inizializza(Vector<Paziente> pListaPazienti){
		this.listapazienti=pListaPazienti;
	}

	/**
	 * Metodo per chiamare la finestra di registrazione
	 * @throws IOException
	 * */
	@FXML
	protected void registrazione() throws IOException{
		FXMLLoader root= new FXMLLoader(getClass().getResource("Registrazione-view.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root.load(), 800, 600));
		stage.setTitle("Registrazione");
		stage.setResizable(false);
		HelloController controller=root.getController();
		controller.inizializza(listapazienti);
		stage.show();
		creaFile();
	}

	/**
	 * Metodo per resettare i campi di registrazione
	 */
	@FXML
	protected void resetRegistrazione(){
		txtCognome.setText("");
		txtNome.setText("");
		txtPatologia.setText("");
		txtTelefono.setText("");
		txtCF.setText("");
	}

	/**
	 * Metodo per salvare i dati inseriti nella registrazione.
	 * Se non sono stati inseriti tutti i dati, viene mostrato un messaggio di errore
	 */
	@FXML
	protected void salvaRegistrazione(){
		if(txtCognome.getText().isEmpty() || txtNome.getText().isEmpty() || txtCF.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtPatologia.getText().isEmpty()){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Errore");
			alert.setHeaderText("Errore nella registrazione");
			alert.setContentText("Compila tutti i campi");
			alert.showAndWait();
		}else{
			scriviFile(concatenaStringa(new Paziente(txtCognome.getText(), txtNome.getText(), txtCF.getText(), txtTelefono.getText(), txtPatologia.getText())));
			//listapazienti.add(new Paziente(txtCognome.getText(), txtNome.getText(), txtCF.getText(), txtTelefono.getText(), txtPatologia.getText()));
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Registrazione avvenuta con successo");
			alert.setContentText("Registrazione avvenuta con successo");
			alert.show();
			txtCognome.setText("");
			txtNome.setText("");
			txtPatologia.setText("");
			txtTelefono.setText("");
			txtCF.setText("");
		}
	}

	/**
	 * Metodo per chiamare la finestra di visualizzazione, mostrando un popup di conferma
	 * */
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

	/**
	 * Metodo per chiamare la finestra di visualizzazione
	 * @throws IOException
	 */
	@FXML
	protected void visualizzazione() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Visualizza-view.fxml"));
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.setScene(new Scene(loader.load(), 800, 600));
		stage.setTitle("Visualizzazione");
		stage.setResizable(false);
		visualizzaController controller = loader.getController();
		controller.inizializza();
		stage.show();
	}


}

