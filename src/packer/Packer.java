package packer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a packer that is efficient at packing full boxes.
 * 
 * @author bunta, Charles Tsao
 * @version 1.0
 */
public class Packer {

    /**
    * Packer class that packs the items from the manifest into boxes
    * 
    * @param c Customer who ordered the products
    * @param d Depot where products are to be shipped from
    * @param m Manifest of products ordered by customer
    * @return A list of packed boxes
    */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
      
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c, d); // LOGICAL ERROR - Arguments for Box object in wrong order round
            }

            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());

            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            }
            else {
                b.addProduct(prodToAdd);
                m.removeProduct(prodToAdd);
            }
        }

        if (b != null) {
            packedBoxes.add(b); //LOGICAL ERROR - There was a duplicate line
        }

        return packedBoxes;  
    }
}
