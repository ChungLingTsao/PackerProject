/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.packer;

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
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }  
  
    @Test
    public void testCanFit(){
        Product p1 = new Product("P1", 39, true, true);
        Coordinates c1 = new Coordinates(1, 1);
        Address a1 = new Address("Street1", "Suburb1", "City1", "123", c1);
        Customer cust1 = new Customer("Clera",a1);
        Depot d1 = new Depot("Depot1", a1);

        Box b1 = new Box(cust1, d1);

        assertEquals(true, b1.canFit(p1));
    }
}
