package packer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad, Charles Tsao
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;
    private Map<Product, Integer> cannotSet;

    public Manifest() {
        quantities = new LinkedHashMap<>(); // Changed to LinkedHashMap to preserve insertion order. Mainly used for testing.
        byWeight = new TreeSet<>(new ProductWeightComparator());
        cannotSet = new LinkedHashMap<>();
    }
    
    public void addProduct(Product p) {
        addProduct(p,1);
    } 
    
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)+quantity); // LOGICAL ERROR: OPERATOR changed to + from *
        }
        else {
            if(!byWeight.add(p)) {
                cannotSet.put(p,1); // REFACTOR: Removed the System.out.println for easier testing and neater console output
            }
            else {
                quantities.put(p,quantity); // Occurs if adding an additional quantity to existing product
            }
        }
    }
    
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        }
        else if (quantities.get(p) == 0) { // Changed to 'ELSE IF' incase quantities gets set to 0 in previous IF statement
            quantities.remove(p); 
        }
        if (quantities.containsKey(p) && quantities.get(p) == 0 ) {  // LOGICAL ERROR, ADDED quantity = 0 criteria when removing fom byWeight
            byWeight.remove(p);
        }
    }

    public double getTotalWeight() { // LOGICAL ERROR: Function was returning TOTAL weight of A product and not TOTAL weight of ALL products
        double weight = 0;
        double total_weight = 0;  //added
        for (Product p : quantities.keySet()) {
            weight = quantities.get(p) * p.getWeight(); 
            total_weight = total_weight + weight; //added
        }
        return total_weight; //changed to total_weight
    }

    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }
    
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    
    // Created to detect if any hazardous items in manifest
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
    
    // Created during refactoring of AddProduct Function to detect products that cannot be set.
    public String cannotSetProduct() {
        if (cannotSet.isEmpty()) {
            return "N/A";
        }
        else {
            return String.format("Couldn't add '%s' to Set", cannotSet.keySet().toString().replace("[", "").replace("]", ""));
        }
    }
} // } added bracket to close class
