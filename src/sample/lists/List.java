package sample.lists;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import sample.items.Item;

public class List {

    //Atributos
    private SimpleStringProperty listName;
    private SimpleStringProperty listDescription;
    private ObservableList<Item> itemsList;
    private SimpleIntegerProperty pendingItems;
    private SimpleDoubleProperty pendingEstimate;

    //Constructor
    public List(String listName, String listDescription){

        this.listName = new SimpleStringProperty();
        this.listDescription = new SimpleStringProperty();

        this.setListName(listName);
        this.setListDescription(listDescription);
    }

    private void setListName(String listName){
        this.listName.set(listName);
    }

    private void setListDescription(String listDescription){
        this.listDescription.set(listDescription);
    }

    public void addItem(Item item){
        this.itemsList.add(item);
        this.setPendingItems();
        this.setPendingEstimate();
    }

    public void setPendingItems(){//Cuenta cuantos articulos hay pendientes
        int ctr = 0;
        for (Item item: itemsList) {
            if (item.getIsPending()){
                ctr++;
            }
        }
        this.pendingItems.set(ctr);
    }

    public void setPendingEstimate(){
        for (Item item: itemsList) {

        }
    }
}
