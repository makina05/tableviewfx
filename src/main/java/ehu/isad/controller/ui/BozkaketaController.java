package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.model.HerrialdeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class BozkaketaController implements Initializable {

    private static int studentid = 3;
    private static int puntuakid = 0;
    @FXML
    private TableView<HerrialdeModel> tbData;
    @FXML
    private TableColumn<HerrialdeModel, Integer> studentId;

    @FXML
    private TableColumn<HerrialdeModel, String> firstName;

    @FXML
    private TableColumn<HerrialdeModel, Integer> puntuakId;

    @FXML
    private TableColumn<HerrialdeModel, String> lastName;

    @FXML
    private TableColumn<HerrialdeModel, Image> image;

    @FXML
    private Button sartubotoia;

    @FXML
    private Button ezabatubotoia;

    @FXML
    private Button gordebotoia;


    private Main main;

    // add your data here from any source
    private ObservableList<HerrialdeModel> studentsModels = FXCollections.observableArrayList(
            new HerrialdeModel(0,1, "Jon", "Guridi", "photo.jpg"),
            new HerrialdeModel(0,2, "Ane", "Bengoa", "security.png"),
            new HerrialdeModel(0,3, "Albania", "Bengoa", "albania.png"),
            new HerrialdeModel(0,4, "Alemania", "Bengoa", "alemania.png"),
            new HerrialdeModel(0,5, "Austria", "Bengoa", "austria.png"),
            new HerrialdeModel(0,6, "Azerbaiyan", "Bengoa", "azerbaiyan.png"),
            new HerrialdeModel(0,7, "Belgika", "Bengoa", "belgika.png"),
            new HerrialdeModel(0,8, "Bielorrusia", "Bengoa", "bielorrusia.png"),
            new HerrialdeModel(0,9, "Bosnia", "Bengoa", "bosnia.png"),
            new HerrialdeModel(0,10, "Bulgaria", "Bengoa", "bulgaria.png"),
            new HerrialdeModel(0,11, "Chipre", "Bengoa", "chipre.png")
            );



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tbData.setEditable(true);
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        puntuakId.setCellValueFactory(new PropertyValueFactory<>("PuntuakId"));
        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));


        studentId.setCellFactory(
            TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        puntuakId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        Callback<TableColumn<HerrialdeModel, String>, TableCell<HerrialdeModel, String>> defaultTextFieldCellFactory
            = TextFieldTableCell.<HerrialdeModel>forTableColumn();

        lastName.setCellFactory(col -> {
            TableCell<HerrialdeModel, String> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getFirstName().equals("Jon")) {
                        cell.setEditable(false);
                    }else {
                        cell.setEditable(true);
                    }
                }
            });

            return cell ;
        });


        lastName.setOnEditCommit(
            t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow())
                    .setLastName(t.getNewValue());


            }
        );

       image.setCellValueFactory(new PropertyValueFactory<HerrialdeModel, Image>("image"));

       image.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(50);
                    imageview.setFitWidth(50);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
            }else{
                    setGraphic(null);
                    setText(null);
                }
        };
     });

        //add your data to the table here.
        tbData.setItems(studentsModels);
    }


    public void setMainApp(Main main) {
        this.main = main;
    }

    public void sartu(ActionEvent actionEvent) {

//        try(InputStream in = new URL("https://www.eldiario.es/fotos/mejores-memes-debate-electoral_EDIIMA20191102_0433_26.jpg").
//            openStream()){
//            Files.copy(in, Paths.get("build/resources/main/memes.jpg"));
//            Files.copy(in, Paths.get("src/main/resources/memes.jpg"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        studentsModels.add(new HerrialdeModel(0,0,"meme","last", "security.png"));

    }

    public void gorde(ActionEvent actionEvent) {
        System.out.println("gorde");
    }

    public void ezabatu(ActionEvent actionEvent) {
        int selectedIndex = tbData.getSelectionModel().getSelectedIndex();
       if (selectedIndex>=0)
            studentsModels.remove(selectedIndex);
    }
}