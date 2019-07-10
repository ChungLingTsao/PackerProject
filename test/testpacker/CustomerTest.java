package testpacker;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;

/**
 * Test class for Customer.java
 * 
 * @author bunta, Charles Tsao
 * @version 1.0
 */
public class CustomerTest {

    // Test data
    Coordinates Coord0 = new Coordinates(0,0);
    Coordinates Coord1 = new Coordinates(3,4);
    Coordinates Coord2 = new Coordinates(30,40);
    Coordinates Coord3 = new Coordinates(300, 400);
    Coordinates Coord4 = new Coordinates(3000, 4000);
    
    Address testAddress0 = new Address("111 Emerge Rd", "Really", "Inn Town", "D444", Coord0);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", Coord1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", Coord2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", Coord3);
    Address testAddress4 = new Address("55 Some St", "Somewhere", "Elsewhere", "E555", Coord4);
    
    Depot testDepot0 = new Depot("Test Depot", testAddress0);
    Depot testDepot4 = new Depot("Test Depot", testAddress4);
    
    /**
     * Console output indicating start of CustomerTest class.
     */    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Customer class...");
    }

    /**
     * Test of getClosestAddressTo method, of class Customer.
     */
    @Test
    public void testGetClosestAddressTo() {
        // ^ WAS AN ERROR: Test originally failed due wrong implementation of getClsestAddressTo
        // Maybe this should be broken int three tests. 
        System.out.println(" -getClosestAddressTo");
        Customer testCustomer;
        
        testCustomer = new Customer("Test Customer", testAddress3);
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress2);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress0);
        assertEquals(testAddress0, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer = new Customer("Test Customer", testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress2);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress3);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress4);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer = new Customer("Test Customer", testAddress2);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress3);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        
        testCustomer.addAddress(testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
    }

    /**
     * Separates console output between test classes.
     */    
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }
    
}
