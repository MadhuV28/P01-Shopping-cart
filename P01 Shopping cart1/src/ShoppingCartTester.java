
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (Shopping Cart Tester
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru
// Email: mvuyyuru@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
public class ShoppingCartTester {
  /**
   * 
   * @param args
   */
  public static void main(String args[]) {
    System.out.println("runAllTests: " + runAllTests());
  }


  /**
   * Checks whether ShoppingCart.lookupProductByName() and ShoppingCart.lookupProductById() methods
   * work as expected. return true when this test verifies a correct functionality, and false
   * otherwise
   * 
   * @return returns true if all tests are passed and false otherwise
   */
  public static boolean testLookupMethods() {
    // 1. The item to find is at index 0 of the marketItems array
    String expectedOutput = "4390 Apple $1.59";
    if (!ShoppingCart.lookupProductByName("Apple").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Apple as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4390).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id " + "of Apple as input");
      return false;
    }
    // 2. The item to find is at the last non-null position of
    // the marketItems array
    expectedOutput = "4688 Tomato $1.79";
    if (!ShoppingCart.lookupProductByName("Tomato").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the id " + "of Apple as input");
      return false;
    }
    // 3. The item to find is at an arbitrary position of the middle of the
    // marketItems array
    expectedOutput = "4046 Avacado $0.59";
    if (!ShoppingCart.lookupProductByName("Avacado").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Chocolate as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4046).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id" + "of Chocolate as input");
      return false;
    }
    // 4. The item to find is not found in the market
    expectedOutput = "No match found";
    if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the name of "
          + "a product not found in the market.");
      return false;
    }
    if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the identifier"
          + "of a product not found in the market.");
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of ShoppingCart.getProductPrice() method Returns true when this test
   * verifies a correct functionality, and false if any bug is detected with respect to the test
   * scenarios defined in this tester
   * 
   * @return true when the test confirms a correct implementation, and false if any error is found
   *         in the test examples.
   */
  public static boolean testGetProductPrice() {
    // define test scenarios
    // first test scenario: get the price of Apple
    double expectedPrice = 1.59; // price of the product Apple in the market
    // Note that we do not use the == operator to check whether two
    // floating-point numbers (double or float) in java are equal.
    // Two variables a and b of type double are equal if the absolute
    // value of their difference is less or equal to a small threshold epsilon.
    // For instance, if Math.abs(a - b) <= 0.001, then a equals b
    if (Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when passed the identifier of "
          + "a product that is first in the market.");
      return false;
    }
    // get the price of an item in the middle of market
    expectedPrice = 0.59;
    if (Math.abs(ShoppingCart.getProductPrice("Avocado") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when passed the identifier of "
          + "a product that is in the middle of the market.");
      return false;
    }
    // get the price of item that doesnn't exist
    expectedPrice = 0.49;
    if (Math.abs(ShoppingCart.getProductPrice("Banana") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when passed the identifier of "
          + "a product not found in the market.");
      return false;
    }

    return true;
  }

  /**
   * This tester method checks the correctness of addItemToCart, contains, and nbOccurrences methods
   * defined in the ShoppingCart class
   * 
   * @return true when the test confirms a correct implementation and false if any error is found in
   *         the examples
   */
  public static boolean testAddItemToCartContainsNbOccurrences() {
    // test 1: adding an item when cart is empty
    String item = "Banana";
    String[] cart = new String[10];
    int size = 0;
    int expected = 1;
    if (ShoppingCart.addItemToCart(item, cart, size) != expected) {
      System.out.println("Problem detected: Your addItemToCart() method "
          + "failed to return the expected output when the cart is empty");
      return false;
    }
    // test 2: adding item to cart when cart is full
    item = "Eggs";
    cart = new String[] {"Apple", "Avacado", "Banana", "Beef"};
    size = 4;
    expected = 4;
    if (ShoppingCart.addItemToCart(item, cart, size) != expected) {
      System.out.println("Problem detected: Your addItemToCart() method "
          + "failed to return the expected output when the cart is full");
      return false;
    }
    // test 3: adding item to cart when cart has available space
    item = "Eggs";
    cart = new String[] {"Apple", "Avacado", "Banana", "Beef", null, null, null};
    size = 4;
    expected = 5;
    if (ShoppingCart.addItemToCart(item, cart, size) != expected) {
      System.out.println("Problem detected: Your addItemToCart() method "
          + "failed to return the expected output when the cart has space and not empty");
      return false;
    }

    return true;
  }

  /**
   * This tester method checks the correctness of removeItem() method defined in the ShoppingCart
   * class
   * 
   * @return true when the test confirms a correct implementation and false if any error is found in
   *         the examples
   */
  public static boolean testRemoveItem() {
    // test 1: remove an item from empty cart
    String item = "Apple";
    String[] cart = new String[5];
    int size = 0;
    int expectedReturn = 0;
    if (ShoppingCart.removeItem(cart, item, size) != (expectedReturn)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when removing from an empty cart");
      return false;
    }
    // test 2: remove a non-existing item from the cart
    item = "Eggs";
    cart = new String[] {"Milk", "Apple", "Banana", "Pizza", "Milk", null, null};
    size = 5;
    expectedReturn = 5;
    if (ShoppingCart.removeItem(cart, item, size) != (expectedReturn)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when an item is not found");
      return false;
    }
    // test 3: removing item that is at index 0 of cart
    item = "Apple";
    cart = new String[] {"Milk", "Apple", "Banana", "Apple", "Pizza", null, null};
    size = 5;
    expectedReturn = 4;
    if (ShoppingCart.removeItem(cart, item, size) != (expectedReturn)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Apple is removed");
      return false;
    }
    // test4: remove item when first occurrence is at index size -1;
    item = "Milk";
    cart = new String[] {"Cereal", "Apple", "Banana", "Pizza", "Milk", null, null};
    size = 5;
    expectedReturn = 4;
    if (ShoppingCart.removeItem(cart, item, size) != (expectedReturn)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when an item is located at index size-1 ");
      return false;
    }
    // test 5: successful removal
    cart = new String[] {"Cereal", "Apple", "Banana", "Pizza", "Milk", null, null};
    size = 5;
    item = "Apple";
    int expectedOccurences = 1;
    ShoppingCart.removeItem(cart, item, size);
    if (ShoppingCart.nbOccurrences(item, cart, size) != expectedOccurences) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when an item is removed");
      return false;
    }
    return true;
  }

  /**
   * This tester method checks the correctness of checkout and getCartSummary() methods defined in
   * the ShoppingCart class
   * 
   * @return true when the test confirms a correct implementation and false if any error is found in
   *         the examples
   */
  public static boolean testCheckoutGetCartSummary() {
    String[] cart = new String[7];
    int size = 0;
    String expectedReturn = "";
    if (!ShoppingCart.getCartSummary(cart, size).equals((expectedReturn))) {
      System.out.println("Problem detected: Your getCartSummary() method "
          + "failed to return the expected output when removing from an empty cart");
      return false;
    }
    cart = new String[] {"Apple", "Avacado", "Banana", "Beef", null, null};
    size = 4;
    expectedReturn = "(1) Apple\n" + "(1) Avacado\n" + "(1) Banana\n" + "(1) Beef\n";
    if (!ShoppingCart.getCartSummary(cart, size).equals((expectedReturn))) {
      System.out.println("Problem detected: Your getCartSummary() method "
          + "failed to return the expected output when the cart has unique items");
      return false;
    }
    cart = new String[] {"Tomato", "Milk", "Milk", "Eggs", "Tomato", "Onion", "Eggs", "Milk",
        "Banana", null, null};
    size = 9;
    expectedReturn = "(2) Tomato\n" + "(3) Milk\n" + "(2) Eggs\n" + "(1) Onion\n" + "(1) Banana\n";
    if (!ShoppingCart.getCartSummary(cart, size).equals((expectedReturn))) {
      System.out.println("Problem detected: Your getCartSummary() method "
          + "failed to return the expected output when when the cart has multiple "
          + "occurances of an item");
      return false;
    }
    return true;
  }

  /**
   * 
   * This tester runs all the tester methods defined in this tester class. For instance, if this
   * tester class defines three tester methods named test1(), test2() and test3(), it will return
   * test1() && test2() && test3() Returns false if any of the tester methods fails, and true if all
   * the tests are passed.
   * 
   * @return false if any of the tester methods fails, and true if all the tests are passed.
   */
  public static boolean runAllTests() {
    if (testLookupMethods() && testGetProductPrice() && testAddItemToCartContainsNbOccurrences()
        && testRemoveItem() && testCheckoutGetCartSummary()) {
      return true;
    }
    return false;
  }
}
