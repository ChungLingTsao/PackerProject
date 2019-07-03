package packer;

/**
 * Represents a depot that is able to dispatch products to customers.
 *
 * @author I.M.Bad, Charles Tsao
 * @version 1.0
 */
public class Depot {
    private String name;
    private Address address;

    /**
    * @param name Name of the depot
    * @param address Address of the depot
    */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    /**
    * @return The name of the depot
    */
    public String getName() {  
      return name; //SYNTAX ERROR: was returning address, not name
    }
    
    /**
    * @return The address of the depot
    */        
    public String getAddress() { // Created a GETTER function for Address 
        return address.toString();   
    }
    
    /**
    * @return The coordinates of the depot
    */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
    * Overrides the toString() from the Java Standard Library to just return the depot name
    * 
    * @return The address of the depot
    */
    @Override
    public String toString() {
        return this.getAddress(); //SYNTAX ERROR: changed getName to new getAddress
    }
    
}
