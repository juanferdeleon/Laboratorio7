package lists;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import items.Item;

public class List {

    //Atributos
    private String listName;
    private String listDescription;
    private ObservableList<Item> itemsList;
    private SimpleIntegerProperty pendingItems;
    private SimpleDoubleProperty pendingEstimate;

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

    public void addItem(Item item){
        this.itemsList.add(item);
        this.setPendingItems();
        this.setPendingEstimate();
    }

    public void setPendingItems(){//Cuenta cuantos articulos hay pendientes
        SimpleIntegerProperty ctr = new SimpleIntegerProperty();
        for (Item item: itemsList) {
            if (item.getIsPending()){
                ctr.add(item.getItemQuant());
            }
        }
        this.pendingItems = ctr;
    }

    public void setPendingEstimate(){//Cuenta cuanto es la cantidad estimada de dinero
        SimpleDoubleProperty ctr = new SimpleDoubleProperty();
        for (Item item: itemsList) {
            ctr.add(item.getItemPrice());
        }
        this.pendingEstimate = ctr;
    }

    public String getListName(){
        return this.listName;
    }

    public String getListDescription(){
        return this.listDescription;
    }
}
