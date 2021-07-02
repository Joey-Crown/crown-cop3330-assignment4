package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ToDoListController {


    // adding new list to sidebar
    @FXML public ListView listView;

    public void addList(ToDoList toDoList) {
        listView.getItems().add(toDoList.name);
    }

    public void handleListClick() {

    }


    // menu controller
    @FXML public MenuBar menuBar;

    @FXML public Menu file;
    @FXML public MenuItem newList;
    @FXML public MenuItem editList;
    @FXML public MenuItem deleteList;

    @FXML public Button confirm;
    @FXML public TextField inputNewList;

    public void newListDialog() {
        TextInputDialog listDialog = new TextInputDialog("Enter name of new list");
        listDialog.setHeaderText("New List");
        listDialog.showAndWait();
        TextField input = listDialog.getEditor();
        String name = input.getText();

        ToDoList newToDoList = new ToDoList(name);
        addList(newToDoList);
    }

    // table elements
    @FXML public TableView<Item> tableView;
    @FXML public TableColumn<Item, String> itemsView;
    @FXML public TableColumn<String, Item> dateView;

    // TODO
    // get this working so that clicking on an item in the list view populates that list
    public void displayList() {
        ObservableList<Item> data = FXCollections.observableArrayList(new Item ("test", "07-02-21"), new Item ("test", "07-02-21"), new Item ("test", "07-02-21"));
        tableView.setItems(data);
        itemsView.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        dateView.setCellValueFactory(new PropertyValueFactory<String, Item>("date"));

        tableView.setItems(data);
    }

    public void initialize() {

    }


}
