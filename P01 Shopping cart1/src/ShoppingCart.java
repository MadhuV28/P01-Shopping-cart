import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This class has marketItems and methods that can be run on shopping cart
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
public class ShoppingCart {
  private static final double TAX_RATE = 0.05; // sales tax
  // MarketItems: a perfect-size two-dimensional array that stores the list of
  // available items in a given market
  // MarketItems[i][0] refers to a String representation of the item identifiers
  // MarketItems[i][1] refers the item name. Item names are also unique
  // MarketItems[i][2] a String representation of the unit price
  // of the item in dollars
  private static String[][] marketItems =
      new String[][] {{"4390", "Apple", "$1.59"}, {"4046", "Avocado", "$0.59"},
          {"4011", "Banana", "$0.49"}, {"4500", "Beef", "$3.79"}, {"4033", "Blueberry", "$6.89"},
          {"4129", "Broccoli", "$1.79"}, {"4131", "Butter", "$4.59"}, {"4017", "Carrot", "$1.19"},
          {"3240", "Cereal", "$3.69"}, {"3560", "Cheese", "$3.49"}, {"3294", "Chicken", "$5.09"},
          {"4071", "Chocolate", "$3.19"}, {"4363", "Cookie", "$9.5"}, {"4232", "Cucumber", "$0.79"},
          {"3033", "Eggs", "$3.09"}, {"4770", "Grape", "$2.29"}, {"3553", "Ice Cream", "$5.39"},
          {"3117", "Milk", "$2.09"}, {"3437", "Mushroom", "$1.79"}, {"4663", "Onion", "$0.79"},
          {"4030", "Pepper", "$1.99"}, {"3890", "Pizza", "$11.5"}, {"4139", "Potato", "$0.69"},
          {"3044", "Spinach", "$3.09"}, {"4688", "Tomato", "$1.79"}, null, null, null, null};

  /**
   * Returns a string representation of the item whose name is provided as input
   *
   * @param name name of the item to find
   * @return "itemId name itemPrice" if an item with the provided name was found
   * @throws NoSuchElementException with descriptive error message if no match found
   */
  public static String lookupProductByName(String name) {
    String representation = "";
    try {
      for (int i = 0; i < marketItems.length - 1; i++) {
        if (marketItems[i] != null && name.equals(marketItems[i][1])) {
          representation = marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
        } else {
          NoSuchElementException nExcpt =
              new NoSuchElementException("The name you are searching for does not exist");
          throw nExcpt;
        }
      }
      return representation;
    } catch (NoSuchElementException nExcpt) {
      return nExcpt.getMessage();
    }
  }

  /**
   * Returns a string representation of the item whose id is provided as input
   *
   * @param key id of the item to find
   * @return "itemId name itemPrice" if an item with the provided name was found
   * @throws IllegalArgumentException with descriptive error message if key is not a 4-digits int
   * @throws NoSuchElementException   with descriptive error message if no match found
   */
  public static String lookupProductById(int id) {
    String representation = "";
    for (int i = 0; i < marketItems.length - 1; i++) {
      if (marketItems[i] != null && id == Integer.parseInt(marketItems[i][0])) {
        representation = marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
        return representation;
      }
    }
    return "No match found";
  }

  /**
   * Returns the price in dollars (a double value) of a market item given its name. If no match was
   * found in the market catalog, this method returns -1.0
   * 
   * @param name name of the product to check its price
   * @return the price in dollars (a double value "d") of a market item given its name. If no match
   *         was found in the market catalog, this method returns -1.0
   */
  public static double getProductPrice(String name) {
    double price = 0.0;
    for (int i = 0; i < marketItems.length - 1; i++) {
      if (marketItems[i] != null && name.equals(marketItems[i][1])) {
        price = Double.parseDouble(marketItems[i][2].substring(1));
        return price;
      } else {

      }
    }
    return -1.0;
  }

  /**
   * Returns a deep copy of the marketItems array
   * 
   * @return a deep copy of the marketItems array(array)
   */
  public static String[][] getCopyOfMarketItems() {
    String[][] array = new String[marketItems.length][];
    for (int i = 0; i < marketItems.length; i++) {
      if (marketItems[i] != null) {
        String[] temp = new String[marketItems[i].length];
        for (int j = 0; j < temp.length; j++) {
          temp[j] = marketItems[i][j];
        }
        array[i] = temp;
      } else if (marketItems[i] == null) {

        array[i] = null;
      }
    }
    return array;
  }

  /**
   * Appends an item to a given cart (appends means adding to the end). If the cart is already full
   * (meaning its size equals its length), the item will not be added to the cart. Returns the size
   * of the oversize array cart after trying to add item to the cart. This method returns the same
   * of size without making any change to the contents of the array if it is full.
   * 
   * @param item the name of the product to be added to the cart
   * @param cart an array of strings which contains the names of items in the cart size
   * @param size the number of items in the cart
   * @return returns the size of the oversize array cart
   */
  public static int addItemToCart(String item, String[] cart, int size) {

    if (size < cart.length) {
      cart[size] = item;
      size = size + 1;
    }
    return size;
  }

  /**
   * Returns the number of occurrences of a given item within a cart. This method must not make any
   * changes to the contents of the cart. Returns the number of occurrences of item (exact match)
   * within the oversize array cart. Zero or more occurrences of item can be present in the cart.
   * 
   * @param item the name of the item to search
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return Returns the number of occurrences of a given item within a cart
   */
  public static int nbOccurrences(String item, String[] cart, int size) {
    int occurences = 0;
    size = cart.length;
    for (int i = 0; i < size; i++)
      if (item.equals(cart[i])) {
        occurences++;
      }
    return occurences;
  }

  /**
   * Checks whether a cart contains at least one occurrence of a given item. This method must not
   * make any changes to the contents of the cart. Returns true if there is a match (exact match) of
   * item within the provided cart, and false otherwise.
   * 
   * @param item the name of the item to search
   * @param cart the name of the item to search
   * @param size the number of items in the cart
   * @return true if there is a match (exact match) of item within the provided cart, and false
   *         otherwise.
   */
  public static boolean contains(String item, String[] cart, int size) {
    for (int i = 0; i < size; i++) {
      if (cart[i] != null && cart[i].equals(item)) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method returns the total value in dollars of the cart. All products in the market are
   * taxable (subject to TAX_RATE).Returns the total value in dollars of the cart accounting taxes.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the total value in dollars of the cart accounting taxes.
   */
  public static double checkout(String[] cart, int size) {
    double totalPrice = 0.0;
    for (int i = 0; i <= size; i++) {
      totalPrice += getProductPrice(cart[i]);
    }
    totalPrice = totalPrice + (totalPrice * TAX_RATE);
    return totalPrice;
  }

  /**
   * Removes one occurrence of item from a given cart. If no match with item was found in the cart,
   * the method returns the same value of input size without making any change to the contents of
   * the array. Returns the size of the oversize array cart after trying to remove item from the
   * cart.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param item the name of the item to remove
   * @param size the number of items in the cart
   * @return the size of the oversize array cart after trying to remove item from the cart.
   */
  public static int removeItem(String[] cart, String item, int size) {
    for (int i = 0; i < size; i++) {
      if (cart[i].equals(item)) {
        cart[i] = null;
        size -= 1;
        return size;
      }
    }
    return size;
  }

  /**
   * Removes all items from a given cart. The array cart must be empty (contains only null
   * references) after this method returns.the size of the cart after removing all its items.
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return the size of the cart after removing all its items.
   */
  public static int emptyCart(String[] cart, int size) {
    int startSize = size;
    for (int i = 0; i < startSize; i++) {
      cart[i] = null;
      size--;
    }
    return size;
  }

  /**
   * Returns a string representation of the summary of the contents of a given cart. The format of
   * the returned string contains a set of lines where each line contains the number of occurrences
   * of a given item, between parentheses, followed by one space followed by the name of a unique
   * item in the cart. (#occurrences) name1 (#occurrences) name2 etc. Further details about the
   * format of the returned string is provided in the next section. Returns a string representation
   * of the summary of the contents of the cart
   * 
   * @param cart an array of strings which contains the names of items in the cart
   * @param size the number of items in the cart
   * @return a string representation of the summary of the contents of a given cart.
   */
  public static String getCartSummary(String[] cart, int size) {
    String summary = "";
    String[] counted = new String[size];
    for (int i = 0; i < size; i++) {
      if (!contains(cart[i], counted, size)) {
        summary = summary + "(" + nbOccurrences(cart[i], cart, size) + ") " + cart[i] + "\n";
        counted[i] = cart[i];
      }
    }
    return summary;
  }
}
