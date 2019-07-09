package packer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer for the company.
 * 
 * @author I.M.Bad, Charles Tsao
 * @version 1.0
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    /**
     * @param name Name of the customer
     * @param address Address of the customer
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * @param address Adding an address to the customer
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * @return The name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * @param d The depot where the products are to be shipped from
     * @return The closest customer address to the depot
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestAddress = a;
                bestDistance = distance; // LOGICAL ERROR: bestDistance now set properly instead of remaining at MAX_VALUE
            }
        }
        return bestAddress;
    }
    
    /**
     * Overrides the toString() from the Java Standard Library to just return the customer name
     * 
     * @return The name of the customer
     */
    @Override
    public String toString() {
        return this.getName();
    }
    
}
