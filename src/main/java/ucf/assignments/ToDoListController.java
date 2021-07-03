package ucf.assignments;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ToDoListController {


    // adding new list to sidebar
    @FXML public ListView listView;

    public void addList(ToDoList toDoList) {
        listView.getItems().add(toDoList.name);
    }

    // menu controller
    @FXML public MenuBar menuBar;

    @FXML public Menu file;
    @FXML public MenuItem newList;
    @FXML public MenuItem editList;
    @FXML public MenuItem deleteList;

    @FXML public Button confirm;
    @FXML public TextField inputNewList;

    // table elements
    @FXML public TableView<Item> tableView;
    @FXML public TableColumn<Item, String> itemsView;
    @FXML public TableColumn<String, Item> dateView;

    // TODO
    // get this working so that clicking on an item in the list view populates that list
    public void displayList(String name) {
        ObservableList<Item> data = FXCollections.observableArrayList(ToDoList.listOfItems.get(name));
        tableView.setItems(data);
        itemsView.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        dateView.setCellValueFactory(new PropertyValueFactory<String, Item>("date"));

        tableView.setItems(data);
    }

    public void initialize() {

        // opens a dialog that prompts the user to enter the name of a list and then initializes a list with that name
        TextInputDialog listDialog = new TextInputDialog("Enter name of new list");
        listDialog.setHeaderText("New List");

        EventHandler<ActionEvent> onNewListClick = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listDialog.showAndWait();
                TextField input = listDialog.getEditor();
                String name = input.getText();

                ToDoList newToDoList = new ToDoList(name);
                addList(newToDoList);
                displayList(newToDoList.name);
            }
        };

        // opens new list dialogue on click
        newList.setOnAction(onNewListClick);


        // click item in listView to display items
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                String name = newValue.toString();
                displayList(name);
            }
        });

    }


}
