# Simple Java Shopping Cart

A simple Java console-based shopping cart system that simulates a small product store. Supports different product types, customer balance tracking, stock validation, and shipping.

## Table of Contents

- [Features](#features)  
- [Product Types](#product-types)  
- [How Checkout Works](#how-checkout-works)  
- [Example Output](#example-output)   

## Features

- Add various products (cheese, TV, scratchcards) to a cart  
- Each product includes:  
  - Price  
  - Weight  
  - Stock quantity  
  - Flags: `shippable`, `expirable`  
- Customer with name and balance  
- Cart functionality:  
  - Validates stock before adding  
  - Calculates subtotal and shipping fees  
  - Identifies shippable items  
- ShippingService prints shipment details and total weight  

## Product Types

Configured in the `Product` constructor:

| Product      | Price | Weight (g) | Shippable | Expirable |
|--------------|-------|------------|-----------|-----------|
| Cheese       | 100   | 200        | Yes       | Yes       |
| Biscuit      | 150   | 700        | Yes       | Yes       |
| TV           | 200   | 2000       | Yes       | No        |
| Scratchcard  | 50    | 0          | No        | No        |

## How Checkout Works

1. Subtotal = sum of (price × quantity) for each cart item  
2. Shipping fee = 10.0 per shippable unit  
3. Customer balance must cover (subtotal + shipping)  
4. Shippable items are passed to the `ShippingService`  
5. Receipt and shipment summary printed to console  

## Example Output

![idea64_tUiRuNt626](https://github.com/user-attachments/assets/55488cfa-d480-4867-ade8-3b52727001df)
