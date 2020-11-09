package ehu.isad.controller.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.model.HerrialdeModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AukeratutaController {
    private Main main;
    private String aukera;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuk;

    @FXML
    private ImageView img;

    @FXML
    private Text textId;

    @FXML
    void onClick(ActionEvent event) {
        main.bozkatuErakutsi();
    }

    @FXML
    void initialize(URL location, ResourceBundle resources) {
        }

    public void idatzi(HerrialdeModel herrialdea){
        this.textId.setText(herrialdea.getFirstName()+ "k bere puntuak banatu ditu jada");
       // this.irudiaKargatu(herrialdea.getImage());
    }

    private void irudiaKargatu(String izena){
        InputStream imagePath = getClass().getResourceAsStream("/albania.png");
        try {
            img.setImage(new Image(new FileInputStream(String.valueOf(imagePath))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setMainApp (Main main){
        this.main = main;
    }
}
