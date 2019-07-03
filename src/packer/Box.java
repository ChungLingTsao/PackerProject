package packer;

/**
 * Represents a box used by the company for packaging products.
 * 
 * @author I.M.Bad, Charles Tsao
 * @version 1.0
 */
public class Box {
    
    /** Set the maximum allowed weight for a company standard box */
    public int MAX_BOX_WEIGHT = 20; // Default set to 20kg
    
    /** Set the minimum required weight to deem a box HEAVY */
    public int HEAVY_LIMIT = 20;
    
    private Manifest contents;
    private Customer customer;
    private Depot depot;
    
    /**
    * @param customer Customer to deliver to 
    * @param depot Depot to deliver from
    */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
    * Adds one product to the contents of a box
    * 
    * @param product Product to add to box
    */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }

    /**
    * Adds an amount of product to the contents of a box
    * 
    * @param product Product to add to box
    * @param quantity Amount of product to add
    */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }

    /**
    * Concatenates a String label from fields relating to the box
    * 
    * @return String Label for the box
    */    
    public String getLabel() { // REFACTOR: Adjusted for output readibility
        StringBuilder label = new StringBuilder();
        label.append("-----------------\n");
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n*****************");
        label.append("\n");
        label.append(contents.toString());
        label.append("\n*****************");
        if (this.isFragile()) {
            label.append("\n[[[[ FRAGILE ]]]]");
        }
        return label.toString();
    }
    
    /**
     * @return Label for the box
     */
    @Override
    public String toString() {
        return getLabel();
    }

    /**
     * @return Weight of the box (in kilograms)
     */
    public double getWeight() {
        return contents.getTotalWeight(); // SYNTAX ERROR - getTotalWeight NOT getWeight 
    }
    
    // FIX: Removed duplicate addProduct(arg) Function
    
    /**
     * @param p The product to check if it can still fit in the box
     * @return Validity of the product fitting in the box
     */
    public boolean canFit(Product p) {
        return p.getWeight() <= MAX_BOX_WEIGHT; // LOGICAL ERROR - DID NOT TAKE INTO ACCOUNT if WEIGHT is equal. CHANGED from < to <=.
    }
    
    /**
     * @param p The product to check if it can still fit in the box
     * @param quantity The amount of product to check
     * @return Validity of the total quantity of the product fitting in the box
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) <= MAX_BOX_WEIGHT; // LOGICAL ERROR - DID NOT TAKE INTO ACCOUNT if WEIGHT is equal. CHANGED from < to <=.
    }

    /**
     * @return The remaining capacity of the box (in kilograms)
     */
    public double remainingCapacity() {
        return MAX_BOX_WEIGHT - this.getWeight();
    }

    /**
     * @return Validity of the box containing fragile items
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     * @return Validity of the box containing hazardous items
     */
    public boolean isHazardous() { // Getter function added as 'hazardous' field appears in the constructor of Product
        return contents.hasHazardousItems(); // LOGICAL ERROR: Was false causing no boxes to be hazardous
    }
    
    /**
     * @return Validity of the box being too heavy
     */
    public boolean isHeavy() {
        return contents.getTotalWeight() >= HEAVY_LIMIT;
    }
}
