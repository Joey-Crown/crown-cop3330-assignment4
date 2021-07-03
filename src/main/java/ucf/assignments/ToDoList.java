package ucf.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoList {

    static Map<String, ArrayList<Item>> listOfItems = new HashMap<String, ArrayList<Item>>();
    String name;

    public ToDoList(String name) {
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("Default list item", "07-02-2021"));

        this.listOfItems.put(name, itemList);
        this.name = name;
    }

}
