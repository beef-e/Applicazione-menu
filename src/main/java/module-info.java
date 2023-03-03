module com.menu.appmenu {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.menu.appmenu to javafx.fxml;
	exports com.menu.appmenu;
}