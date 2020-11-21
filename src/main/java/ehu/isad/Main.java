package ehu.isad;

import ehu.isad.controller.ui.HasieraController;
import ehu.isad.controller.ui.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

  private Parent hasieraUI, menuUI;
  private Stage stage;
  private HasieraController hasieraController;
  private MenuController menuController;

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("/menu.fxml"));
    primaryStage.setTitle("WhatWeb");
    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.setScene(new Scene(root));
    primaryStage.show();

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("WhatWeb");
   // stage.initStyle(StageStyle.UNDECORATED);
    stage.setScene(new Scene(menuUI));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {



//    FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
//    hasieraUI = (Parent) loaderHasiera.load();
//    hasieraController = loaderHasiera.getController();
//    hasieraController.setMainApp(this);

    FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/menu.fxml"));
    menuUI = (Parent) loaderMenu.load();
    menuController = loaderMenu.getController();
    menuController.setMainApp(this);

    FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderHasiera.load();
    hasieraController = loaderHasiera.getController();
    hasieraController.setMainApp(this);


  }


  public static void main(String[] args) {
    launch(args);
  }

//  public void bozkatuErakutsi() {
//    stage.setScene(new Scene(bozkaketaUI));
//    stage.show();
//  }

}