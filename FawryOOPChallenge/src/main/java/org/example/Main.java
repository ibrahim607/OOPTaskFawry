package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("running");
        Customer ibrahim = new Customer("ibrahim",1600);
        Product cheese      = new Product("Cheese",5);
        Product biscuit    = new Product("biscuit",3);
        Product tv          = new Product("Tv",4);
        Product scratchCard = new Product("scratchcard",8);

        Cart cart = new Cart();
        cart.addProduct(cheese,2);
        cart.addProduct(tv,1);
        cart.addProduct(biscuit,1);
        cart.addProduct(scratchCard,2);

        ShippingService shippingService = new ShippingService();
        cart.checkout(shippingService,ibrahim);
    }
}