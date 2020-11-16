package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MenuController {
private Main main;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCMS;

    @FXML
    private Button btnServer;

    @FXML
    private Button btnW;

    @FXML
    private Pane pnCMS;

    @FXML
    private Label lblCMS;

    @FXML
    private Label lblPrev;

    @FXML
    private StackPane sp;

    @FXML
    private AnchorPane apCMS;

    @FXML
    private AnchorPane apServer;

    @FXML
    private AnchorPane apW;

    @FXML
    void onClickCMS(ActionEvent event) {
        if (event.getSource() == btnCMS){
            apCMS.toFront();
        } else if (event.getSource() == btnServer){
            apServer.toFront();
        } else {
            apW.toFront();
        }
    }

    @FXML
    void onClickServer(ActionEvent event) {

    }

    @FXML
    void onClickW(ActionEvent event) {

    }

    @FXML
    void initialize() {


    }


    public void setMainApp(Main main) {
        this.main = main;
    }
}
