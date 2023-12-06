package edu.psu.ist;

/**
 * The Manufacturer class represents a car manufacturer with a name and country of origin.
 */
public class Manufacturer {
    private String name; // The name of the manufacturer
    private String country; // The country of origin of the manufacturer

    /**
     * Constructs a Manufacturer object with the specified name and country.
     *
     * @param name    The name of the manufacturer.
     * @param country The country of origin of the manufacturer.
     */
    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    /**
     * Gets the name of the manufacturer.
     *
     * @return The name of the manufacturer.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the country of origin of the manufacturer.
     *
     * @return The country of origin.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the name of the manufacturer.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the country of origin of the manufacturer.
     *
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Returns a string representation of the manufacturer, including its name and country of origin.
     *
     * @return A formatted string representing the manufacturer.
     */
    @Override
    public String toString() {
        return name + ", " + country;
    }
}
