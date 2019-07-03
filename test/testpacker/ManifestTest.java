package testpacker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedHashMap;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import packer.Manifest;
import packer.Product;
import java.util.Map;
import java.util.TreeSet;
import org.junit.AfterClass;
import packer.ProductWeightComparator;

/**
 *
 * @author Charles Tsao
 */
public class ManifestTest {
 
    // This tracks the quantity if each product in the manifest
    public Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;  
    
    Manifest manifest = new Manifest();
    Product product = new Product("Hammer", 3, false, false);
    Product product2 = new Product("Danger Hammer", 1, true, true);
    Product product3 = new Product("Hammer", 3, false, false);
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    /**
     * Test of addProduct method, of class Manifest.
     */
    @Test
    public void testAddProduct() {
        System.out.println(" -addProduct");
        byWeight = new TreeSet<>(new ProductWeightComparator());
        
        manifest.addProduct(product);
        manifest.addProduct(product2, 1);
        assertEquals("Hammer x 1\nDanger Hammer x 1", manifest.toString());
        
        manifest.addProduct(product3, 1);
        assertEquals("Couldn't add 'Hammer' to Set", manifest.cannotSetProduct());
    }
    
    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct() {
        System.out.println(" -removeProduct");
        manifest.addProduct(product);
        manifest.removeProduct(product);
        assertEquals(true, manifest.isEmpty());
        
        manifest.addProduct(product2);
        assertEquals(false, manifest.isEmpty());
    }
    
    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println(" -getTotalWeight");
        manifest.addProduct(product);
        assertEquals(3.0, manifest.getTotalWeight(), 0.0001);
    }
    
    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        System.out.println(" -getHeaviestUnder");      
        manifest.addProduct(product);
        manifest.addProduct(product2);

        assertEquals(product, manifest.getHeaviestUnder(10));
        assertEquals(product2, manifest.getHeaviestUnder(2));
    }
    
    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println(" -isEmpty");
        byWeight = new TreeSet<>(new ProductWeightComparator());
        assertEquals(true, byWeight.isEmpty());
        
        byWeight.add(product);
        assertEquals(false, byWeight.isEmpty());
    }
    
    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        System.out.println(" -containsProduct");
        manifest.addProduct(product);
        assertEquals(true, manifest.containsProduct(product));
        assertEquals(false, manifest.containsProduct(product2));
    }
    
    /**
     * Test of toString method, of class Manifest.
     */
    @Test
    public void testToString() {
        System.out.println(" -toString");
        quantities = new LinkedHashMap<>();
        
        manifest.addProduct(product, 1);
        assertEquals("Hammer x 1", manifest.toString());
        
        manifest.addProduct(product2, 5);
        assertEquals("Hammer x 1\nDanger Hammer x 5", manifest.toString());
    }

    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println(" -hasFragileItems");
        assertEquals(false, product.isFragile());     
        assertEquals(true, product2.isFragile());     
    }
    
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }
}
