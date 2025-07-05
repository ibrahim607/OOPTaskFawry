package org.example;

public class Product implements ShippableItems{
    private String productName;
    private double productPrice;
    private int productQuantity;
    private double productWeight;
    private boolean isShippable;
    private boolean isExpirable;

    public Product(String name, int quantity) {
        setProductName(name);
        setProductQuantity(quantity);
        setProductPrice(0.0);
        setProductWeight(0);
        setShippable(false);
        setExpirable(false);

        switch (name.toLowerCase()) {
            case "cheese":
            case "biscuit":
                this.isShippable = true;
                this.isExpirable = true;
                if ("cheese".equalsIgnoreCase(name)) {
                    setProductWeight(200);
                    setProductPrice(100);
                } else if ("biscuit".equalsIgnoreCase(name)) {
                    setProductWeight(700);
                    setProductPrice(150);
                }
                break;
            case "tv":
                this.isShippable = true;
                setProductPrice(200);
                setProductWeight(2000);
                break;
            case "scratchcard":
                    setProductPrice(50);
                break;
            default:
                break;
        }
    }
    public void decreaseQuantity(int orderAmount){
        if (orderAmount > productQuantity) {
            throw new IllegalArgumentException(
                    String.format("Cant reduce quantity by %d. Only %d available for %s.",
                            orderAmount, productQuantity, productName));
        }
        productQuantity -= orderAmount;
    }

    public boolean isExpirable(){
        return isExpirable;
    }
    public boolean isShippable(){
        return isShippable;
    }

    public String getProductName(){
        return productName;
    }
    public double getProductPrice(){
        return productPrice;
    }

    public int getProductQuantity(){
        return productQuantity;
    }

    public void setProductName(String name){
        productName = name;
    }
    public void setProductPrice(double price){
        productPrice = price;
    }
    public void setProductQuantity(int quantity){
        productQuantity = quantity;
    }


    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double weight) {
        this.productWeight = weight;
    }

    public void setExpirable(boolean expirable) {
        isExpirable = expirable;
    }

    public void setShippable(boolean shippable) {
        isShippable = shippable;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public double getWeight() {
        return productWeight;
    }
}
