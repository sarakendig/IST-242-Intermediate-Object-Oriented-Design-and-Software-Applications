package edu.psu.ist;

/**
 * The Vehicle class represents a vehicle with details such as its model, manufacturer,
 * vehicle type, odometer mileage, and miles per gallon (mpg).
 */
public class Vehicle {
    private Model model; // The model of the vehicle
    private Manufacturer manufacturer; // The manufacturer of the vehicle
    private VehicleType vehicleType; // The type of the vehicle
    private double odometerMileage; // The odometer mileage of the vehicle
    private double mpg; // The miles per gallon of the vehicle

    /**
     * Constructs a Vehicle object with the specified parameters.
     *
     * @param model           The model of the vehicle.
     * @param manufacturer    The manufacturer of the vehicle.
     * @param vehicleType     The type of the vehicle.
     * @param odometerMileage The odometer mileage of the vehicle.
     * @param mpg             The miles per gallon of the vehicle.
     */
    public Vehicle(Model model, Manufacturer manufacturer, VehicleType vehicleType, double odometerMileage, double mpg) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.vehicleType = vehicleType;
        this.odometerMileage = odometerMileage;
        this.mpg = mpg;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Gets the manufacturer of the vehicle.
     *
     * @return The manufacturer of the vehicle.
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Gets the type of the vehicle.
     *
     * @return The type of the vehicle.
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * Gets the odometer mileage of the vehicle.
     *
     * @return The odometer mileage of the vehicle.
     */
    public double getOdometerMileage() {
        return odometerMileage;
    }

    /**
     * Gets the miles per gallon of the vehicle.
     *
     * @return The miles per gallon of the vehicle.
     */
    public double getMpg() {
        return mpg;
    }

    /**
     * Returns a string representation of the vehicle, including its model, manufacturer,
     * production details, vehicle type, odometer mileage, and miles per gallon (mpg).
     *
     * @return A formatted string representing the vehicle.
     */
    @Override
    public String toString() {
        String modelDetails = model.getModelName() + ", in production = " + model.getInProduction() + ", " +
                model.getProductionYears().get(0).getValue() + " (" + manufacturer.getName() + ", " +
                manufacturer.getCountry() + ")\n " +
                vehicleType.getKind() + ", wheels: " + vehicleType.getNumberOfTires() + "\n " +
                "odometer: " + odometerMileage + " - mpg: " + mpg;
        return modelDetails;
    }
}
