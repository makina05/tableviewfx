package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class AukeratutaController {
    private Main main;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuk;

    @FXML
    private ImageView img;

    @FXML
    void onClick(ActionEvent event) {
        main.bozkatuErakutsi();
    }

    @FXML
    void initialize() {

    }
    public void setMainApp(Main main){
        this.main = main;
    }
}
