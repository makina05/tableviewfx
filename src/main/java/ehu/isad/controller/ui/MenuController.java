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
//       // Parent root = FXMLLoader.load(getClass().getResource("/Hasiera.fxml"));
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
import animatefx.animation.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {
    private Main main;

    @FXML
    private WhatWebController whatwebController;

    @FXML
    private CMSController cmsController;

    @FXML
    private ServerController serverController;

    @FXML
    private HasieraController hasieraController;

    // hemen kargatzen direnak automatikoki egiten du FXML-n includeak dituelak
    //beste kontroler baten saiatzen bagara kanpoko controller bat instantziatzen ez du automatikoki egiten, horrek ez duelako includea

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

    @FXML
    private AnchorPane Hasiera;

    //ostean erabili dugun eraikitzailea hau ezartzea ere behar du funtziona dezan
    public MenuController() {

    }
    // eraikitzaileak argumentu bat behar duenez programatu behar da, besteetan ez da behar programatzea defektuzkoa erabiltzen daualako
    public MenuController(Main main) {

        this.main = main;
    }

    @FXML
    void changeScene(ActionEvent event) {
//atal honetan kargatuko dira pane ezberdinak sakatutako botoiaren arabera; gainera, animazioak hemen txertatzen dira
        if (event.getSource()==btnCMS) {
            paneCMS.toFront();
            paneCMS.requestFocus();
            main.kargatuTaula();
            //animazioa
            new RotateIn(paneCMS).play();
        } else if (event.getSource()==btnServer){
            paneServer.toFront();
            paneServer.requestFocus();
            main.kargatuEskaneatutakoak();
            //animazioa
            new Wobble(paneServer).play();
        } else if (event.getSource()==btnWhatWeb)
            paneWhatWeb.toFront();
            paneWhatWeb.requestFocus();
            //animazioa
            new Pulse(paneWhatWeb).play();
    }



    @FXML
    void onClickIxa(MouseEvent event) {
        java.lang.System.exit(0);
    }
//    public void setMainApp(Main main) {
//        this.main = main;
//    }

    @FXML
    void initialize() {
        this.Hasiera.toFront();
    }


}
