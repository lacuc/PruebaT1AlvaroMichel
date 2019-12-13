package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador2 {

	@FXML
	AnchorPane rootPane;

	@FXML
	private Pane pane1, pane2, pane3, pane4;

	@FXML
	private ImageView imgView;

	public void initialize() {

		pane1.setStyle("-fx-background-image: url('view.assets/StarsAtNight.jpg')");
		pane2.setStyle("-fx-background-image: url('view.assets/LunasUrano.jpg')");
		pane3.setStyle("-fx-background-image: url('view.assets/SolarSystem.jpg')");
		pane4.setStyle("-fx-background-image: url('view.assets/letMeIn.jpg')");

		carrusel();

	}

	public void carrusel() {

		FadeTransition fdtstn = new FadeTransition(Duration.seconds(3), pane4);
		fdtstn.setFromValue(1);
		fdtstn.setToValue(0);
		fdtstn.play();

		fdtstn.setOnFinished(event -> {
			FadeTransition fdtstn1 = new FadeTransition(Duration.seconds(3), pane3);
			fdtstn1.setFromValue(1);
			fdtstn1.setToValue(0);
			fdtstn1.play();

			fdtstn1.setOnFinished(event1 -> {

				FadeTransition fdtstn2 = new FadeTransition(Duration.seconds(3), pane2);
				fdtstn2.setFromValue(1);
				fdtstn2.setToValue(0);
				fdtstn2.play();

				fdtstn2.setOnFinished(event2 -> {

					FadeTransition fdtstn12 = new FadeTransition(Duration.seconds(3), pane2);
					fdtstn12.setFromValue(0);
					fdtstn12.setToValue(1);
					fdtstn12.play();

					fdtstn12.setOnFinished(event3 -> {
						FadeTransition fdtstn13 = new FadeTransition(Duration.seconds(3), pane3);
						fdtstn13.setFromValue(0);
						fdtstn13.setToValue(1);
						fdtstn13.play();

						fdtstn13.setOnFinished(event4 -> {
							FadeTransition fdtstn14 = new FadeTransition(Duration.seconds(3), pane4);
							fdtstn14.setFromValue(0);
							fdtstn14.setToValue(1);
							fdtstn14.play();

							fdtstn14.setOnFinished(event5 -> {
								carrusel();
							});
						});

					});
				});

			});

		});
	}

	@FXML
	private void closeApp() {
		Stage thisStage = (Stage) rootPane.getScene().getWindow();
		thisStage.close();
	}

}
