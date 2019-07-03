package testpacker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Box;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;
import packer.Product;

/**
 *
 * @author Charles Tsao
 */
public class BoxTest {
    
    Product p1 = new Product("P1", 20, true, true);
    Product p2 = new Product("P2", 1, true, true);
    Coordinates c1 = new Coordinates(1, 1);
    Address a1 = new Address("Street1", "Suburb1", "City1", "123", c1);
    Customer cust1 = new Customer("Clera",a1);
    Depot d1 = new Depot("Depot1", a1);

    Box b1 = new Box(cust1, d1);
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }  
    
    // Both AddProduct functions are not tested as it stores products in a manifest class.
    
    @Test
    public void testGetWeight(){
        System.out.println(" -getWeight");
        b1.MAX_BOX_WEIGHT = 20;
        b1.addProduct(p1);
        assertEquals(20.0, b1.getWeight(), 0.001);
    }
    
    @Test
    public void testCanFit(){
        System.out.println(" -canFit");
        
        b1.MAX_BOX_WEIGHT = 15;
        assertEquals(false, b1.canFit(p1));
        
        b1.MAX_BOX_WEIGHT = 25;
        assertEquals(true, b1.canFit(p1));
    }
    
    @Test
    public void testRemainingCapacity() {
        System.out.println(" -remainingCapacity");  
        b1.MAX_BOX_WEIGHT = 50;
        b1.addProduct(p1);
        assertEquals(50-20, b1.remainingCapacity(), 0.001);
    }
    
    @Test
    public void testIsFragile() {
        System.out.println(" -isFragile");
        b1.addProduct(p1);
        assertEquals(true, b1.isFragile());
    }
    
    @Test
    public void testIsHazardous() {
        System.out.println(" -isHazardous");  
        b1.addProduct(p1);
        assertEquals(true, b1.isHazardous());
    }
    
    @Test
    public void testIsHeavy() {
        b1.addProduct(p2); //p2 weight is 1kg
        assertEquals(false, b1.isHeavy());
        
        b1.addProduct(p1); //p1 weight is 20kg
        assertEquals(true, b1.isHeavy());
    }
    
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }
}
