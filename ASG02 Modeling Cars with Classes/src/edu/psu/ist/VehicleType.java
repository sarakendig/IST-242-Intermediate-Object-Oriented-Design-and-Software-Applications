package edu.psu.ist;

/**
 * The VehicleType class represents a type of vehicle with a kind and the number of tires it has.
 */
public class VehicleType {
    /**
     * The Kind enum represents the type or category of a vehicle.
     */
    public enum Kind {
        TRUCK, SEDAN, COUPE, STATION_WAGON, VAN
    }

    private final Kind kind; // The kind of vehicle (e.g., TRUCK, SEDAN, etc.)
    private final int numberOfTires; // The number of tires the vehicle has

    /**
     * Constructs a VehicleType object with the specified kind and number of tires.
     *
     * @param kind          The kind or category of the vehicle.
     * @param numberOfTires The number of tires the vehicle has.
     * @throws IllegalArgumentException if the number of tires is not between 3 and 5.
     */
    public VehicleType(Kind kind, int numberOfTires) {
        if (numberOfTires < 3 || numberOfTires > 5) {
            throw new IllegalArgumentException("Invalid number of wheels!");
        }

        this.kind = kind;
        this.numberOfTires = numberOfTires;
    }

    /**
     * Gets the kind or category of the vehicle.
     *
     * @return The kind of the vehicle.
     */
    public Kind getKind() {
        return kind;
    }

    /**
     * Gets the number of tires the vehicle has.
     *
     * @return The number of tires.
     */
    public int getNumberOfTires() {
        return numberOfTires;
    }

    /**
     * Returns a string representation of the vehicle type, including its kind and the number of tires.
     *
     * @return A formatted string representing the vehicle type.
     */
    @Override
    public String toString() {
        return kind + ", wheels: " + numberOfTires;
    }
}