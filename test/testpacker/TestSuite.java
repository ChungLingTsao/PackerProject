package testpacker;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite for Packer Program
 * 
 * @author bunta, Charles Tsao
 * @version 1.0
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

    /**
     * Console output indicating start of Test Suite.
     */
    @BeforeClass
    public static void setUpTestSuiteHeading() {
        System.out.println("*** Running TestSuite for Packer Software v1.0 ***\n");
    }
    
    /**
     * Console output indicating that the test suite has finished.
     */
    @AfterClass
    public static void closingTestSuite() {
        System.out.println("*** Testing Finished ***");
    }

}
