import java.time.Year;

/**
 * The abstract class Vehicle represents a base class for various types of vehicles.
 * It includes information about the manufacturer, auto model, and provides methods for common vehicle properties.
 */
abstract class Vehicle implements Comparable<Vehicle> {
    private Manufacturer manufacturer;      // The manufacturer of the vehicle.
    private AutoModel autoModel;            // model of the vehicle.

    /**
     * Constructs a Vehicle object with the specified manufacturer and auto model.
     *
     * @param manufacturer The manufacturer of the vehicle.
     * @param autoModel    The model of the vehicle.
     */
    public Vehicle(Manufacturer manufacturer, AutoModel autoModel) {
        this.manufacturer = manufacturer;
        this.autoModel = autoModel;
    }

    // gets manufacturer of the vehicle
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    // gets auto model of the vehicle
    public AutoModel getAutoModel() {
        return autoModel;
    }

    // gets number of wheels on vehicle
    public abstract int numberOfWheels();

    // gets release year
    public abstract Year getReleaseYear();

    /**
     * Compares this vehicle to another vehicle based on their release years.
     *
     * @param o Another vehicle to compare to.
     * @return A negative integer if this vehicle's release year is earlier,
     *         0 if they have the same release year, and a positive integer if this vehicle's release year is later.
     */
    @Override
    public int compareTo(Vehicle o) {
        return this.getReleaseYear().compareTo(o.getReleaseYear());
    }
}