import java.time.Year;

/**
 * The Sedan class represents a type of vehicle that is a sedan.
 * It extends the Vehicle class and adds specific properties for sedans, such as mpg (miles per gallon).
 */
class Sedan extends Vehicle {
    private double mpg;  // miles per gallon of sedan

    /**
     * Constructs a Sedan object with the specified manufacturer, auto model, and mpg.
     *
     * @param manufacturer The manufacturer of the sedan.
     * @param autoModel    The model of the sedan.
     * @param mpg          The miles per gallon (mpg) of the sedan.
     */
    public Sedan(Manufacturer manufacturer, AutoModel autoModel, double mpg) {
        super(manufacturer, autoModel);
        this.mpg = mpg;
    }
    /**
     * Returns the number of wheels of the sedan, which is always 4 for a sedan.
     *
     * @return The number of wheels (4).
     */
    @Override
    public int numberOfWheels() {
        return 4;
    }

    // gets release year of sedan
    @Override
    public Year getReleaseYear() {
        return getAutoModel().getProductionYears().get(0);
    }


     // Gets the miles per gallon (mpg) of the sedan.

    public double getMPG() {
        return mpg;
    }

    /**
     * Returns a string representation of the Sedan object.
     * The format is: "(manufacturer) model, mpg: mpg"
     *
     * @return A string representation of the Sedan object.
     */

    @Override
    public String toString() {
        return super.getManufacturer() + " " + super.getAutoModel() + ", mpg: " + mpg;
    }
}