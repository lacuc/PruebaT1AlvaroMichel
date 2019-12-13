package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Controlador {

	@FXML
	ImageView fotoLogin;

	@FXML
	AnchorPane rootPane;

	@FXML
	AnchorPane pane;

	public void initialize() {

		transicion();

	}

	private void transicion() {

		FadeTransition fdtsn = new FadeTransition(Duration.seconds(4), fotoLogin);
		fdtsn.setFromValue(0);
		fdtsn.setToValue(1);
		fdtsn.play();

	}

	@FXML
	public void openStage() {

		closeApp();

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Urano.fxml"));
			AnchorPane pane1 = (AnchorPane) loader.load();
			Stage stage1 = new Stage();
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void closeApp() {
		Stage stage = (Stage) rootPane.getScene().getWindow();
		stage.close();
	}

}
