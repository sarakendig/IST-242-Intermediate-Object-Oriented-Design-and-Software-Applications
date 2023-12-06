import java.time.Year;

/**
 * The Truck class represents a type of vehicle that is a truck.
 * It extends the Vehicle class and adds specific properties for trucks, such as whether it is a dually and its mpg (miles per gallon).
 */
class Truck extends Vehicle {
    private boolean isDually;   // whether the truck is a dually
    private double mpg;         // miles per gallon (mpg) of the truck

    /**
     * Constructs a Truck object with the specified manufacturer, auto model, dually status, and mpg.
     *
     * @param manufacturer The manufacturer of the truck.
     * @param autoModel    The model of the truck.
     * @param isDually     A flag indicating whether the truck is a dually.
     * @param mpg          The miles per gallon (mpg) of the truck.
     */
    public Truck(Manufacturer manufacturer, AutoModel autoModel, boolean isDually, double mpg) {
        super(manufacturer, autoModel);
        this.isDually = isDually;
        this.mpg = mpg;
    }

    public Truck(Manufacturer manufacturer, AutoModel autoModel, double mpg) {
        this(manufacturer, autoModel, false, mpg); // Assume not a dually by default
    }


    /**
     * Gets the number of wheels of the truck.
     *
     * @return The number of wheels, which is 6 if the truck is a dually, or 4 if it is not.
     */

    @Override
    public int numberOfWheels() {
        return isDually ? 6 : 4;
    }


    /**
     * Gets the release year of the truck by retrieving it from the associated auto model.
     *
     * @return The release year of the truck.
     */
    @Override
    public Year getReleaseYear() {
        return getAutoModel().getProductionYears().get(0);
    }

    /**
     * Gets the miles per gallon (mpg) of the truck.
     *
     * @return The miles per gallon (mpg) of the truck.
     */
    public double getMPG() {
        return mpg;
    }


    /**
     * Returns a string representation of the Truck object.
     * The format is: "(manufacturer) model, mpg: mpg, is-dually: isDually".
     *
     * @return A string representation of the Truck object.
     */
    @Override
    public String toString() {
        return super.getManufacturer() + " " + super.getAutoModel() + ", mpg: " + mpg + ", is-dually: " + isDually;
    }
}