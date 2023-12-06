
/**
 * The Manufacturer class represents a manufacturer of automobiles.
 * It stores the manufacturer's name and country.
 */
public class Manufacturer {

    private String name;        // name of manufacturer
    private String country;     // country where manufacturer is located


    /**
     * * Constructs a Manufacturer object with the given name and country.
     * @param name = name of the manufacturer.
     * @param country = country where the manufacturer is based.
     */
    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // gets name of manufacturer
    public String getName() {
        return name;
    }

    // gets country where manufacturer is located
    public String getCountry() {
        return country;
    }

    /**
     * @return a string of the Manufacturer object.
     *         The format is: "<name>, <country>"
     */
    @Override
    public String toString() {
        return "<" + name + ">, <" + country + ">";
    }
}
