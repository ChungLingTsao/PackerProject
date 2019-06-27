package test.packer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.packer.AddressTest;
import test.packer.CoordinatesTest;
import test.packer.CustomerTest;
import test.packer.DepotTest;
import test.packer.ProductTest;


/**
 *
 * @author bunta
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CoordinatesTest.class,
    AddressTest.class,
    DepotTest.class,
    ProductTest.class,
    CustomerTest.class
})

public class TestSuite {
    // No code required here.
}
