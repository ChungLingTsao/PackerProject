package packer;

import java.util.Comparator;

/**
 * Comparator used to compare products by weight and sort products by weight descending.
 * 
 * @author I.M.Bad, Charles Tsao
 * @version 1.0
 */
public class ProductWeightComparator implements Comparator<Product> {
    
    /**
    * Compares the weight of two products and returns a value that determines whether or not it is swapped in the list
    * 
    * @param a First product to compare weight to 
    * @param b Second product to compare weight to 
    * @return A value that is used for sorting a given list
    */
    public int compare(Product a, Product b) {
        if (a.getWeight() < b.getWeight()) {return 1;}
        else if (a.getWeight() > b.getWeight()) {return -1;}
        else return a.getName().compareTo(b.getName());
    }
}
