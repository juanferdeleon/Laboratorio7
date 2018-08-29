package items;

public class Item {

    private String itemName;
    private Integer itemQuant;
    private Double itemPrice;
    private Double itemTotal;
    private Boolean isPending = true;

    public Item(String itemName, Integer itemQuant, Double itemPrice){
        this.setItemName(itemName);
        this.setItemQuant(itemQuant);
        this.setItemPrice(itemPrice);
        this.setItemTotal();
    }

    private void setItemName(String itemName){
        this.itemName = itemName;
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

    public String getItemName(){
        return this.itemName;
    }

    public Double getItemTotal(){
        return this.itemTotal;
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
