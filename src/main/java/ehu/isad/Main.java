package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent bozkaketaUI, hasieraUI, comboUI, aukeratutaUI, topUI; //TOP falta
  private Stage stage;
  private BozkaketaController bozkaketaController;
  private HasieraController hasieraController;
  private ComboController comboController;
  private AukeratutaController aukeratutaController;
  private TopController topController;

  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(new Scene(hasieraUI, 650, 475));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderBozkaketa = new FXMLLoader(getClass().getResource("/tableview.fxml"));
    bozkaketaUI = (Parent) loaderBozkaketa.load();
    bozkaketaController = loaderBozkaketa.getController();
    bozkaketaController.setMainApp(this);


    FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderHasiera.load();
    hasieraController = loaderHasiera.getController();
    hasieraController.setMainApp(this);

    FXMLLoader loaderCombo = new FXMLLoader(getClass().getResource("/combo.fxml"));
    comboUI = (Parent) loaderCombo.load();
    comboController = loaderCombo.getController();
    comboController.setMainApp(this);

    FXMLLoader loaderAukeratuta = new FXMLLoader(getClass().getResource("/aukeratuta.fxml"));
    aukeratutaUI = (Parent) loaderAukeratuta.load();
    aukeratutaController = loaderAukeratuta.getController();
    aukeratutaController.setMainApp(this);

    FXMLLoader loaderTop = new FXMLLoader(getClass().getResource("/top.fxml"));
    topUI = (Parent) loaderTop.load();
    topController = loaderTop.getController();
    topController.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void bozkatuErakutsi() {
    stage.setScene(new Scene(bozkaketaUI));
    stage.show();
  }
  public void comboErakutsi(){
    stage.setScene(new Scene(comboUI));
    stage.show();
  }
  public void aukeratutaErakutsi(){
    stage.setScene(new Scene(aukeratutaUI));
    stage.show();
  }
  public void topErakutsi(){
    stage.setScene(new Scene(topUI));
    stage.show();
  }
}