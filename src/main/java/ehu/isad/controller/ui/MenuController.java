//package ehu.isad.controller.ui;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
//import ehu.isad.Main;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import org.w3c.dom.events.MouseEvent;
//
//public class MenuController {
//private Main main;
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button btnCMS;
//
//    @FXML
//    private Button btnServer;
//
//    @FXML
//    private Button btnW;
//
//    @FXML
//    private Pane pnCMS;
//
//    @FXML
//    private Label lblCMS;
//
//    @FXML
//    private Label lblPrev;
//
//    @FXML
//    private StackPane sp;
//
//    @FXML
//    private AnchorPane apCMS;
//
//    @FXML
//    private AnchorPane apServer;
//
//    @FXML
//    private AnchorPane apW;
//
//    @FXML
//    private FontAwesomeIconView ixa;
//
//    @FXML
//    void onClickCMS(ActionEvent event) {
//        if (event.getSource() == btnCMS){
//            apCMS.toFront();
//        } else if (event.getSource() == btnServer){
//            apServer.toFront();
//        } else {
//            apW.toFront();
//        }
//    }
//
//    @FXML
//    void onClickServer(ActionEvent event) {
//
//    }
//
//    @FXML
//    void onClickW(ActionEvent event) throws IOException {
//       // Parent root = FXMLLoader.load(getClass().getResource("/hasiera.fxml"));
//    }
//
//    @FXML
//    void initialize() {
//
//
//    }
//
//
//    public void setMainApp(Main main) {
//        this.main = main;
//    }
//
//    public void onClickIxa(javafx.scene.input.MouseEvent mouseEvent) {
//        java.lang.System.exit(0);
//    }
//}

package ehu.isad.controller.ui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button btnCMS;

    @FXML
    private Button btnServer;

    @FXML
    private Button btnWhatWeb;

    @FXML
    private FontAwesomeIconView ixa;

    @FXML
    private AnchorPane paneCMS;

    @FXML
    private AnchorPane paneServer;

    @FXML
    private AnchorPane paneWhatWeb;
    private Main main;

    @FXML
    void changeScene(ActionEvent event) {

        if (event.getSource()==btnCMS) {
            paneCMS.toFront();
        } else if (event.getSource()==btnServer){
            paneServer.toFront();
        } else if (event.getSource()==btnWhatWeb)
            paneWhatWeb.toFront();
    }



    @FXML
    void onClickIxa(MouseEvent event) {
        java.lang.System.exit(0);
    }
    public void setMainApp(Main main) {
        this.main = main;
    }

}
