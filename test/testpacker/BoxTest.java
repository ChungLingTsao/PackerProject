package testpacker;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Box;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;
import packer.Manifest;
import packer.Product;

/**
 * Test class for Box.java
 * 
 * @author Charles Tsao
 * @version 1.0
 */
public class BoxTest {
    
    // Test data
    Product p1 = new Product("P1", 20, true, true);
    Product p2 = new Product("P2", 1, true, true);
    Coordinates c1 = new Coordinates(1, 1);
    Address a1 = new Address("Street1", "Suburb1", "City1", "123", c1);
    Customer cust1 = new Customer("Clera",a1);
    Depot d1 = new Depot("Depot1", a1);

    Box b1 = new Box(cust1, d1);
    Manifest contents;
    String expected;
    
    /**
     * Console output indicating start of BoxTest class.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }  
    
    /**
     * Test of addProduct(args[0]) method, of class Box.
     */
    @Test
    public void testAddProduct(){
        System.out.println(" -addProduct(args[0])");
        contents = new Manifest();       
        contents.addProduct(p1);
        assertEquals(true, contents.containsProduct(p1));
        assertEquals("P1 x 1", contents.toString());
        assertEquals(false, contents.containsProduct(p2));
    }
    
    /**
     * Test of addProduct(args[0],args[1]) method, of class Box.
     */
    @Test
    public void testAddMultipleProducts(){
        System.out.println(" -addProduct(args[0],args[1])");
        contents = new Manifest();       
        contents.addProduct(p1, 5);
        assertEquals("P1 x 5", contents.toString());
        contents.addProduct(p1, 2);
        assertEquals("P1 x 7", contents.toString());
        contents.addProduct(p2, 3);
        assertEquals("P1 x 7\nP2 x 3", contents.toString());
    }
    
    /**
     * Test of getLabel method, of class Box.
     */
    @Test
    public void testGetLabel(){
        System.out.println(" -getLabel");
        b1.addProduct(p1);
        
        expected = "-----------------\n"
              + "Clera\n"
              + "Street1\n"
              + "Suburb1\n"
              + "City1\n"
              + "123\n"
              + "*****************\n"
              + "P1 x 1\n"
              + "*****************\n"
              + "[[[[ FRAGILE ]]]]\n"
              + "[[[[  HAZARD ]]]]\n"
              + "[[[[  HEAVY  ]]]]";

        assertEquals(expected, b1.getLabel());
    }
    
    /**
     * Test of toString method, of class Box.
     */
    @Test
    public void testToString(){
        System.out.println(" -toString");
        b1.addProduct(p1);
        b1.toString();
        
        expected =
            "-----------------\n"
            + "Clera\n" 
            + "Street1\n"
            + "Suburb1\n"
            + "City1\n"
            + "123\n"
            + "*****************\n"
            + "P1 x 1\n"
            + "*****************\n"
            + "[[[[ FRAGILE ]]]]\n"
            + "[[[[  HAZARD ]]]]\n"
            + "[[[[  HEAVY  ]]]]";

        assertEquals(expected, b1.toString());
    }
    
    /**
     * Test of getWeight method, of class Box.
     */
    @Test
    public void testGetWeight(){
        System.out.println(" -getWeight");
        b1.MAX_BOX_WEIGHT = 20;
        b1.addProduct(p1);
        assertEquals(20.0, b1.getWeight(), 0.001);
    }
    
    /**
     * Test of canFit(arg[0]) method, of class Box.
     */
    @Test
    public void testCanFit(){
        System.out.println(" -canFit(arg[0])");
        
        b1.MAX_BOX_WEIGHT = 15;
        assertEquals(false, b1.canFit(p1));
        
        b1.MAX_BOX_WEIGHT = 25;
        assertEquals(true, b1.canFit(p1));
    }
    
    /**
     * Test of canFit(args[0],args[1]) method, of class Box.
     */
    @Test
    public void testCanFitMultiple(){
        System.out.println(" -canFit(args[0],args[1]");
        
        b1.MAX_BOX_WEIGHT = 60;
        assertEquals(true, b1.canFit(p1, 3));
        assertEquals(false, b1.canFit(p1, 4));
        
        b1.MAX_BOX_WEIGHT = 5;
        assertEquals(true, b1.canFit(p2, 5));
        assertEquals(true, b1.canFit(p1, 0));
        assertEquals(false, b1.canFit(p2, 6));
    }
    
    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity() {
        System.out.println(" -remainingCapacity");  
        b1.MAX_BOX_WEIGHT = 50;
        b1.addProduct(p1);
        assertEquals(50-20, b1.remainingCapacity(), 0.001);
    }
    
    /**
     * Test of isFragile method, of class Box.
     */
    @Test
    public void testIsFragile() {
        System.out.println(" -isFragile");
        b1.addProduct(p1);
        assertEquals(true, b1.isFragile());
    }
    
    /**
     * Test of isHazardous method, of class Box.
     */
    @Test
    public void testIsHazardous() {
        System.out.println(" -isHazardous");  
        b1.addProduct(p1);
        assertEquals(true, b1.isHazardous());
    }
    
    /**
     * Test of isHeavy method, of class Box.
     */
    @Test
    public void testIsHeavy() {
        System.out.println(" -isHeavy");  
        b1.addProduct(p2); //p2 weight is 1kg
        assertEquals(false, b1.isHeavy());
        
        b1.addProduct(p1); //p1 weight is 20kg
        assertEquals(true, b1.isHeavy());
    }
    
    /**
     * Separates console output between test classes.
     */
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }

}
