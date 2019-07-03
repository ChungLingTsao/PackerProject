package testpacker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author bunta, Charles Tsao
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CoordinatesTest.class,
    AddressTest.class,
    DepotTest.class,
    ProductTest.class,
    CustomerTest.class,
    BoxTest.class,
    ManifestTest.class, 
    PackerTest.class
})

public class TestSuite {
   
    @BeforeClass
    public static void setUpTestSuiteHeading() {
        System.out.println("*** Running TestSuite for Packer Software v1.0 ***\n");
    }
    
    @AfterClass
    public static void closingTestSuite() {
        System.out.println("*** Testing Finished ***");
    }
}
