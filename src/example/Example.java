package example;

import java.util.List;
import packer.Address;
import packer.Box;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;
import packer.Manifest;
import packer.Packer;
import packer.Product;

/**
 * Example program that demonstrates packer functionality
 * 
 * @author bunta, Charles Tsao
 * @version 1.0
 */
public class Example {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);
        System.out.println("\nDEPOT:");
        System.out.println(depot);
        
        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        Customer customer = new Customer("Andy Bravo", customerAddress1);
        customer.addAddress(customerAddress2);
        System.out.println("\nCUSTOMER:"); // Added ":" to match other headings
        System.out.println(customer);

        Manifest manifest = new Manifest();
        manifest.addProduct(new Product("Hammer", 3, false, false), 1);
        manifest.addProduct(new Product("Nails", 1, false, false), 12);
        manifest.addProduct(new Product("Ladder", 15, false, false), 2);
        manifest.addProduct(new Product("Saw", 5, false, false), 1);
        manifest.addProduct(new Product("Light Bulbs", 1, false, true), 20);
        manifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
        manifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
        
        System.out.println("\nMANIFEST (to be packed):");
        System.out.println(manifest);
        
        System.out.println("\nPACKING:");
        List<Box> done = Packer.packProducts(customer, depot, manifest);

        // Results
        for (Box b : done) {
            System.out.println("-----------------");
            System.out.println("----- Box " + (done.indexOf(b) + 1) + " -----");
            System.out.println(b);
            System.out.println("");
        }
        
        // Display products that are unable to be set
        System.err.println(manifest.cannotSetProduct());
    }  
}
