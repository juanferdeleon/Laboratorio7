package sample.items;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {

    private SimpleStringProperty itemName;
    private SimpleIntegerProperty itemQuant;
    private SimpleDoubleProperty itemPrice;
    private Boolean isPending = true;

    public Item(String itemName, Integer itemQuant, Double itemPrice){
        this.itemName = new SimpleStringProperty();
        this.itemQuant = new SimpleIntegerProperty();
        this.itemPrice = new SimpleDoubleProperty();

        this.setItemName(itemName);
        this.setItemQuant(itemQuant);
        this.setItemPrice(itemPrice);
    }

    private void setItemName(String itemName){
        this.itemName.set(itemName);
    }

    private void setItemQuant(Integer itemQuant){
        this.itemQuant.set(itemQuant);
    }

    private void setItemPrice(Double itemPrice){
        this.itemPrice.set(itemPrice);
    }

    public void setIsPending(){
        this.isPending = !isPending;
    }

    public boolean getIsPending(){
        return this.isPending;
    }

    public SimpleDoubleProperty getItemPrice(){
        return this.itemPrice;
    }
}
