package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.model.HerrialdeModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ComboController {
    private Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<HerrialdeModel> comboId;

    @FXML
    private Button btnCombo;

    @FXML
    public void onClick(ActionEvent event) {
        main.aukeratutaErakutsi();
    }

    @FXML
    public void initialize() {

    }
    public void setMainApp(Main main){
        this.main = main;
    }
}
