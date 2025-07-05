package org.example;

import java.util.List;

public class ShippingService {
    public void processShippableItems(List<ShippableItems> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (ShippableItems item : items) {
            System.out.printf("%s %4.0fg%n", item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }

        System.out.printf("Total package weight: %.1f kg%n", totalWeight / 1000.0);
    }
}
