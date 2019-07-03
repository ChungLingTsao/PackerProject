package packer;

/**
 *
 * @author I.M.Bad, Charles Tsao
 */
public class Depot {
    private String name;
    private Address address;

    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {  
      return name; //SYNTAX ERROR: was returning address, not name
    }
    
    // Created a GETTER function for Address 
    public String getAddress() { 
        return address.toString();   
    }
    
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    @Override //ERROR: ADDED OVERRIDE
    public String toString() {
        return this.getAddress(); //SYNTAX ERROR: changed getName to new getAddress
    }
    
}
