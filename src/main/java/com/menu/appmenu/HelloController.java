package com.menu.appmenu;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
	@FXML
	protected void registrazione() throws IOException{
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Registrazione-view.fxml")));
		Stage stage = new Stage();
		stage.setTitle("Registrazione");
		stage.setScene(new Scene(root, 600, 400));
		stage.setResizable(false);
		stage.show();
	}
}