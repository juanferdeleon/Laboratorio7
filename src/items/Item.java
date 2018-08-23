package items;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {

    private SimpleStringProperty itemName;
    private Integer itemQuant;
    private Double itemPrice;
    private Double itemTotal;
    private Boolean isPending = true;

    public Item(String itemName, Integer itemQuant, Double itemPrice){
        this.itemName = new SimpleStringProperty();

        this.setItemName(itemName);
        this.setItemQuant(itemQuant);
        this.setItemPrice(itemPrice);
    }

    private void setItemName(String itemName){
        this.itemName.set(itemName);
    }

    private void setItemQuant(Integer itemQuant){
        this.itemQuant = itemQuant;
    }

    private void setItemPrice(Double itemPrice){
        this.itemPrice = itemPrice;
    }

    private void setItemTotal(){
        this.itemTotal = this.getItemQuant() * this.getItemPrice();
    }

    public void setIsPending(){
        this.isPending = !isPending;
    }

    public boolean getIsPending(){
        return this.isPending;
    }

    public Integer getItemQuant(){
        return this.itemQuant;
    }

    public Double getItemPrice(){
        return this.itemPrice;
    }
}
