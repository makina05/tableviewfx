package ehu.isad;

import ehu.isad.model.Person;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableViewDemo extends Application {

    private TableColumn<Person, String> userNameCol;
    private TableColumn<Person, String> emailCol;
    private TableColumn<Person, Boolean> activeCol;
    private ObservableList<Person> zerrenda;

    @Override
    public void start(Stage stage) {

        TableView<Person> table = new TableView<Person>();

        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        zutabeakPrestatu(table);

        // Display row data
        zerrenda = getUserList();
        table.setItems(zerrenda);

        // taula panelan sartu
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView");

        Scene scene = new Scene(root, 480, 300);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Person> getUserList() {

        Person user1 = new Person(1L, "smith", "smith@gmail.com", true);
        Person user2 = new Person(2L, "mcneil", "mcneil@gmail.com", true);
        Person user3 = new Person(3L, "white", "white@gmail.com", false);

        ObservableList<Person> list = FXCollections.observableArrayList(user1, user2, user3);
        return list;
    }

    private void zutabeakPrestatu(TableView<Person> table) {

        userNameCol = new TableColumn<Person, String>("User Name");
        emailCol = new TableColumn<Person, String>("Email");
        activeCol = new TableColumn<Person, Boolean>("Active");

        table.getColumns().addAll(userNameCol, emailCol, activeCol);


        // Nola bistaratu gelaxkak (zutabearen arabera)
        // Get value from property of UserAccount.
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));


        // Nola editatu gelaxkak (zutabearen arabera)
        userNameCol.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
       // userNameCol.setMinWidth(100);

        // Nola gorde balio berria modeloan
        // On Cell edit commit (for username column)
        userNameCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> event) -> {

            TablePosition<Person, String> pos = event.getTablePosition();
            String newUserName = event.getNewValue();
            int row = pos.getRow();
            Person person = event.getTableView().getItems().get(row);

            person.setUserName(newUserName);

            System.out.println(zerrenda);
        });
        // Set Sort type for userName column
        userNameCol.setSortType(TableColumn.SortType.DESCENDING);


        // ==== Active? (CHECH BOX) ===
        activeCol.setCellValueFactory(new Callback<>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Person, Boolean> param) {
                Person person = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(person.isActive());

                // Note: activeCol.setOnEditCommit(): Not work for
                // CheckBoxTableCell.

                // When "active?" column change.
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        person.setActive(newValue);
                    }
                });
                return booleanProp;
            }
        });

        activeCol.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Person, Boolean> call(TableColumn<Person, Boolean> p) {
                CheckBoxTableCell<Person, Boolean> cell = new CheckBoxTableCell<Person, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}