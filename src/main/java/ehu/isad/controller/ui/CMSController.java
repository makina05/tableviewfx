package ehu.isad.controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.db.WhatWebDBKud;
import ehu.isad.model.Laguntzailea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import ehu.isad.model.Laguntzailea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CMSController {
    private ObservableList<Laguntzailea> data;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> comboBoxId;

    @FXML
    private Button btnAddURL;

    @FXML
    private TableView<Laguntzailea> tableViewId;

    @FXML
    private TableColumn<Laguntzailea, String> urlId;

    @FXML
    private TableColumn<Laguntzailea, String> cmsId;

    @FXML
    private TableColumn<Laguntzailea, String> versionId;

    @FXML
    private TableColumn<Laguntzailea, String> lastId;

    @FXML
    void initialize() {

    }
    public void kargatuTaula(){
        List<Laguntzailea> lagak = WhatWebDBKud.getInstance().lortuOrrialdeak();
        data = FXCollections.observableArrayList(lagak);

        urlId.setCellValueFactory( new PropertyValueFactory<>("target"));
        versionId.setCellValueFactory( new PropertyValueFactory<>("version"));
        cmsId.setCellValueFactory( new PropertyValueFactory<>("cms"));
        lastId.setCellValueFactory( new PropertyValueFactory<>("lastUp"));

        tableViewId.setItems(data);

    }
}
