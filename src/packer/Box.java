package packer;

/**
 *
 * @author I.M.Bad, Charles Tsao
 */
public class Box {
    
    public int MAX_BOX_WEIGHT = 20; // Default currently set to 20kg for Company Standard Boxes
    private Manifest contents;
    private Customer customer;
    private Depot depot;
    
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }

    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
    public String getLabel() { // REFACTOR: Adjusted for output readibility
        StringBuilder label = new StringBuilder();
        label.append("----------------\n");
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n****************");
        label.append("\n");
        label.append(contents.toString());
        label.append("\n****************");
        if (this.isFragile()) {
            label.append("\n[[[ FRAGILE ]]]");
        }
        return label.toString();
    }
    
    public String toString() {
        return getLabel();
    }
    
    public double getWeight() {
        return contents.getTotalWeight(); // SYNTAX ERROR - getTotalWeight NOT getWeight 
    }
    
    // FIX: Removed duplicate addProduct(arg) Function
    
    public boolean canFit(Product p) {
        return p.getWeight() <= MAX_BOX_WEIGHT; // LOGICAL ERROR - DID NOT TAKE INTO ACCOUNT if WEIGHT is equal. CHANGED from < to <=.
    }
    
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) <= MAX_BOX_WEIGHT; // LOGICAL ERROR - DID NOT TAKE INTO ACCOUNT if WEIGHT is equal. CHANGED from < to <=.
    }
    
    public double remainingCapacity() {
        return MAX_BOX_WEIGHT - this.getWeight();
    }
    
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    // Determines if a box is Hazardous
    public boolean isHazardous() {
        return contents.hasHazardousItems(); //THIS MUST BE AN ERROR....ELSE NO BOXES ARE HAZARDOUS
    }
    
    // Determines if a box is HEAVY
    public boolean isHeavy() {
        return contents.getTotalWeight() >= 20;
    }
}
