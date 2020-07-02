Feature: Add Item to cart

 Scenario Outline:User is able to Add a Product to Cart
    Given User Already Login onto the Website
    When User Add Product to Cart"<Product>"
    Then User Succesfully Add Product to Cart
   Examples:
     |Product|
     |Iphone 11|
     |Laptop Asus|
     |Iphone 5|