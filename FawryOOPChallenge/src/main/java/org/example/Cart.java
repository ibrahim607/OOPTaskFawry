package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> cartItems = new HashMap<>();

    public void addProduct(Product product , Integer amount ){
        if (amount <= 0) throw new IllegalArgumentException("Quantity must be > 0 ");
        if (amount > product.getProductQuantity()) {
            throw new IllegalArgumentException(
                    String.format("cant add %d of %s. Only %d available.",
                            amount, product.getProductName(), product.getProductQuantity()));
        }
        cartItems.put(product, cartItems.getOrDefault(product, 0) + amount);
    }

    public double checkout(ShippingService shippingService, Customer customer) {
        if (cartItems.isEmpty()) {
            throw new IllegalStateException("Cannot checkout with empty cart.");
        }

        double totalWeight = 0.0;
        double subtotal = 0.0;
        int totalShippableUnits = 0;
        List<ShippableItems> itemsToShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (quantity > product.getProductQuantity()) {
                throw new IllegalArgumentException("Product out of stock: " + product.getProductName());
            }
            totalWeight += product.getProductWeight();
            subtotal += product.getProductPrice() * quantity;
            product.decreaseQuantity(quantity);

            if (product.isShippable()) {
                totalShippableUnits += quantity;
                for (int i = 0; i < quantity; i++) {
                    itemsToShip.add(product);
                }
            }
        }

        double shippingFee = totalShippableUnits * 10.0;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("Customer has insufficient balance.");
        }

        customer.setBalance(customer.getBalance() - total);


            shippingService.processShippableItems(itemsToShip);


        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%dx %-12s %6.2f%n", quantity, product.getProductName(), product.getProductPrice() * quantity);
        }
        System.out.println("-----------------------------");
        System.out.printf("Subtotal:       %.2f%n", subtotal);
        System.out.printf("Shipping fees:  %.2f%n", shippingFee);
        System.out.printf("Paid amount:    %.2f%n", total);
        System.out.printf("Remaining balance: %.2f%n", customer.getBalance());

        cartItems.clear();
        return total;
    }

}

