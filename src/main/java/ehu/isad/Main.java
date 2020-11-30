package ehu.isad;

import ehu.isad.controller.ui.CMSController;
import ehu.isad.controller.ui.ServerController;
import ehu.isad.controller.ui.WhatWebController;
import ehu.isad.controller.ui.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;

public class Main extends Application {

  private Parent whatwebUI, menuUI;
  private Stage stage;
  private WhatWebController whatWebController;
  private MenuController menuController;
  private CMSController cmsController;
  private ServerController serverController;

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
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

  //  private void pantailakKargatu() throws IOException {
//
//
//
//    FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/Menu.fxml"));
//    menuUI = (Parent) loaderMenu.load();
//    menuController = loaderMenu.getController();
//    menuController.setMainApp(this);
//
//    FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
//    hasieraUI = (Parent) loaderHasiera.load();
//    hasieraController = loaderHasiera.getController();
//    hasieraController.setMainApp(this);
//
//
//  }
  private void pantailakKargatu() throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));

    menuController = new MenuController(this); //  setMain() metodoa ekidituz
    whatWebController = new WhatWebController();
    cmsController = new CMSController();
    serverController = new ServerController();

    Callback<Class<?>, Object> controllerFactory = type -> {
      if (type == MenuController.class) {
        return menuController;
      } else if (type == WhatWebController.class) {
        return whatWebController;
      } else if (type == CMSController.class) {
        return cmsController;
      } else if (type == ServerController.class) {
        return serverController;
      }
      else {
        // default behavior for controllerFactory:
        try {
          return type.newInstance();
        } catch (Exception exc) {
          exc.printStackTrace();
          throw new RuntimeException(exc); // fatal, just bail...
        }
      }
    };

    loader.setControllerFactory(controllerFactory);

    menuUI = (Parent) loader.load();
  }
}