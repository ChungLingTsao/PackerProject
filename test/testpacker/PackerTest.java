package testpacker;

import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import packer.Address;
import packer.Box;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;
import packer.Manifest;
import packer.Packer;
import packer.Product;

/**
 * Test class for Packer.java
 * 
 * @author Charles Tsao
 * @version 1.0
 */
public class PackerTest {
  
    // Test data
    Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
    Depot depot = new Depot("Main Depot", depotAddress);
    Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
    Customer customer = new Customer("Andy Bravo", customerAddress1);

    Manifest manifest = new Manifest();
    Product product = new Product("Hammer", 3, false, false);
    Product product2 = new Product("Danger Hammer", 1, true, true);
    
    /**
     * Console output indicating start of PackerTest class.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class...");
    }  
 
    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        System.out.println(" -packProducts");
        manifest.addProduct(product, 1);
        manifest.addProduct(product2, 5);
        List<Box> packedproducts = Packer.packProducts(customer, depot, manifest);
        
        assertEquals(
            "["
            + "-----------------\n"
            + "Andy Bravo\n"
            + "67 Torch Rd\n"
            + "Treeline\n"
            + "Mt High\n"
            + "T799\n"
            + "*****************\n" 
            + "Hammer x 1\n"
            + "Danger Hammer x 5\n"
            + "*****************\n"
            + "[[[[ FRAGILE ]]]]\n"
            + "[[[[  HAZARD ]]]]"
            + "]", packedproducts.toString());
    }
    
    /**
     * Separates console output between test classes.
     */
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }
    
}
