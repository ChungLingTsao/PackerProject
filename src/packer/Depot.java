package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {  // Created a GET function for name
      return name;
    }
    
    public String getAddress() {  //SYNTAX ERROR: address not name
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
