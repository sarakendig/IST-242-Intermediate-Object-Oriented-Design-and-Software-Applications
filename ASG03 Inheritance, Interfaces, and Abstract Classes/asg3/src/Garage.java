import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The Garage class represents a storage facility for vehicles. It allows adding, emptying, and sorting vehicles.
 */
class Garage {
    /**
     * A list to store vehicles in the garage.
     */
    private List<Vehicle> vehicles;

    /**
     * Constructs an empty Garage object.
     */
    public Garage() {
        vehicles = new ArrayList<>();
    }

    /**
     * Adds a vehicle to the garage.
     *
     * @param vehicle The vehicle to be added to the garage.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Empties the garage by removing all vehicles.
     */
    public void emptyGarage() {
        vehicles.clear();
    }

    /**
     * Sorts the vehicles in the garage based on their release years.
     */
    public void sortGarage() {
        Collections.sort(vehicles);
    }

    /**
     * Returns a string representation of the Garage object, listing all vehicles in the garage.
     *
     * @return A string representation of the Garage object, with each vehicle on a separate line.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            sb.append(vehicle.toString()).append("\n");
        }
        return sb.toString();
    }
}