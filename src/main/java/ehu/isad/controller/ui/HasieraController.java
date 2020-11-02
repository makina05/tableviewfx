package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HasieraController {
    private Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnHasi;

    @FXML
    void onClick(ActionEvent event) {
        main.comboErakutsi();
    }

    @FXML
    void initialize() {

    }

    public void setMainApp(Main main){
        this.main = main;
    }
}
