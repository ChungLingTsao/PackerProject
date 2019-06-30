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
    
    public String getAddress() { // Created a GET function for Address 
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
