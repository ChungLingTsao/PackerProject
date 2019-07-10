package testpacker;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Coordinates;
import packer.Depot;

/**
 * Test class for Depot.java
 * 
 * @author bunta, Charles Tsao
 * @version 1.0
 */
public class DepotTest {

    // Test data
    Coordinates Coord1 = new Coordinates(0,0);
    Coordinates Coord2 = new Coordinates(30,40);
    Coordinates Coord3 = new Coordinates(1000, 2000);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", Coord1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", Coord2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", Coord3);
    Depot testDepot1 = new Depot("City Depot", testAddress1);
    Depot testDepot2 = new Depot("Suburbs Depot", testAddress2);
    Depot testDepot3 = new Depot("Country Depot", testAddress3);

    /**
     * Console output indicating start of DepotTest class.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Depot class...");
    }
    
    /**
     * Test of getName method, of class Depot.
     */
    @Test
    public void testGetName() {
        System.out.println(" -toString");
        assertEquals("City Depot", testDepot1.getName());
        assertEquals("Suburbs Depot", testDepot2.getName());
        assertEquals("Country Depot", testDepot3.getName());
    }

    /**
     * Test of getCoordinates method, of class Depot.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println(" -getCoordinates");
        assertEquals(Coord1, testDepot1.getCoordinates());
        assertEquals(Coord2, testDepot2.getCoordinates());
        assertEquals(Coord3, testDepot3.getCoordinates());
    }
    
    /**
     * Separates console output between test classes.
     */
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }
    
}
