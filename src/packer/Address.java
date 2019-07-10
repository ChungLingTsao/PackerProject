package packer;

/**
 * Represents an address for a customer or depot.
 * A customer can have multiple addresses.
 * 
 * @author I.M.Bad, Charles Tsao
 * @version 1.0
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;

    /**
     * @param street Street name of Address
     * @param suburb Suburb name of Address
     * @param city City name of Address
     * @param postcode Postcode of Address
     * @param coordinates Coordinates of Address
     */
    public Address(String street, String suburb, String city, String postcode, 
            Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    /**
     * Concatenates the address fields together
     * 
     * @return String containing the whole address
     */
    @Override
    public String toString() {
        return  
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * @return The coordinates of the address
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

}
