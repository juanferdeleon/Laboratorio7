package lists;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import items.Item;

public class List {

    //Atributos
    private String listName;
    private String listDescription;
    private ObservableList<Item> itemsList = FXCollections.observableArrayList();
    private Integer pendingItems;
    private Double pendingEstimate;

    //Constructor
    public List(String listName, String listDescription){

        this.setListName(listName);
        this.setListDescription(listDescription);
    }

    private void setListName(String listName){
        this.listName = listName;
    }

    private void setListDescription(String listDescription){
        this.listDescription = listDescription;
    }

    public void setItemsList(ObservableList<Item> itemsList){
        this.itemsList = itemsList;
    }

    public void addItem(Item item){
        this.itemsList.add(item);
        this.setPendingItems();
        this.setPendingEstimate();
    }

    public void setPendingItems(){//Cuenta cuantos articulos hay pendientes
        Integer ctr = 0;
        for (Item item: itemsList) {
            if (item.getIsPending()){
                ctr+= item.getItemQuant();
            }
        }
        this.pendingItems = ctr;
    }

    public void setPendingEstimate(){//Cuenta cuanto es la cantidad estimada de dinero
        Double ctr = 0.0;
        for (Item item: itemsList) {
            if (item.getIsPending()) {
                item.setItemTotal();
                ctr += item.getItemPrice() * item.getItemQuant();
            }
        }
        this.pendingEstimate = ctr;
    }

    public String getListName(){
        return this.listName;
    }

    public String getListDescription(){
        return this.listDescription;
    }

    public ObservableList<Item> getItemsList(){
        return this.itemsList;
    }

    public Integer getPendingItems(){
        return this.pendingItems;
    }

    public Double getPendingEstimate(){
        return this.pendingEstimate;
    }
}
