package ehu.isad;

import ehu.isad.controller.ui.StudentsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

  private Parent mainUI;
  private Stage stage;
  private StudentsController studentsController;

  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Taula Demo");
    stage.setScene(new Scene(mainUI, 650, 475));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/tableview.fxml"));
    mainUI = (Parent) loaderKautotu.load();
    studentsController = loaderKautotu.getController();
    studentsController.setMainApp(this);

  }


  public static void main(String[] args) {
    launch(args);
  }

  public void mainErakutsi() {
    stage.setScene(new Scene(mainUI));
    stage.show();
  }
}