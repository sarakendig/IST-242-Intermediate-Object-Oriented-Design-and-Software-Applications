package assignments.asg2;

public class Vehicle {
    private Model model;
    private Manufacturer manufacturer;
    private VehicleType vehicleType;
    private double odometerMileage;
    private double mpg;

    public Vehicle() {
        this.model = model;
        this.manufacturer = manufacturer;
        this.vehicleType = vehicleType;
        this.odometerMileage = odometerMileage;
        this.mpg = mpg;
    }

    public Model getModel() {
        return model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getOdometerMileage() {
        return odometerMileage;
    }

    public double getMpg() {
        return mpg;
    }

    @Override
    public String toString() {
        return model.getModelName() + "\n " +
        manufacturer.getName() + "\n" +
        vehicleType.getKind() + "\n" +
        odometerMileage + "miles\n" +
        mpg + "mpg";
    }
}
