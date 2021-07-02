package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

public class Item {

    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleStringProperty date = new SimpleStringProperty("");
    //boolean completed;

    public Item(String description, String date) {
        setDescription(description);
        setDate(date);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

}
