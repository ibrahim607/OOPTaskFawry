# OOPTaskFawry
Features
Add different products (like cheese, TV, scratchcards) to a cart

Each product has:

Price

Weight

Quantity in stock

Flags like shippable and expirable

Customer class tracks user name and wallet balance

Cart ensures:

Products are in stock before adding

Total cost and shipping fees are calculated

Products marked as shippable are listed for shipping

ShippingService handles displaying shipment items and total weight

Product Types
Products are configured using a switch inside the Product class constructor:

Product	Price	Weight (g)	Shippable	Expirable
Cheese	100	200	Yes	Yes
Biscuit	150	700	Yes	Yes
TV	200	2000	Yes	No
Scratchcard	50	0	No	No

How Checkout Works
Each product costs its price × quantity.

Shippable products cost an extra 10.0 per unit for shipping.

If the customer doesn’t have enough balance → checkout fails.

Shipping service prints a summary of what will be shipped and total weight.

Example Output
yaml
Copy
Edit
** Checkout receipt **
2x Cheese        200.00
1x Tv            200.00
1x biscuit       150.00
2x scratchcard   100.00
-----------------------------
Subtotal:       650.00
Shipping fees:  40.00
Paid amount:    690.00
Remaining balance: 910.00

** Shipment notice **
Cheese  200g
Cheese  200g
Tv     2000g
biscuit  700g
Total package weight: 3.1 kg
Project Structure
css
Copy
Edit
org.example/
├── Cart.java
├── Customer.java
├── Main.java
├── Product.java
├── ShippableItems.java
├── ShippingService.java
