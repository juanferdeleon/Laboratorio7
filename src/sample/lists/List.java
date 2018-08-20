package sample.lists;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import sample.items.Item;

public class List {

    SimpleStringProperty listName;
    SimpleIntegerProperty pendingItems;
    SimpleDoubleProperty pendingEstimate;
    ObservableList<Item> listItems;

    

}
