package packer;

/**
 *
 * @author I.M.Bad, Charles Tsao
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

  public Product() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the hazardous
     */
    public boolean isHazardous() {
        return hazardous; // LOGICAL ERROR - Was always returning false 
    }

    /**
     * @return the fragile
     */
    public boolean isFragile() {
        return fragile;
    }

    public String toString() {
        return this.getName();
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
