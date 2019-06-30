package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta, Charles Tsao
 */
public class Packer {

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
          packedBoxes.add(b); //LOGICAL ERROR - duplicate line
        }

        return packedBoxes;
    }
}
