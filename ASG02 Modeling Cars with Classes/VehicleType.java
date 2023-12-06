package assignments.asg2;

public class VehicleType {
    
    public enum Kind {
        TRUCK, SEDAN, COUPE, STATION_WAGON, VAN
    }

    private Kind kind;
    private int numberOfTires;


    public VehicleType(Kind kind, int numberOfTires) {

        if (numberOfTires < 3 || numberOfTires > 5) {
            throw new IllegalArgumentException("invalid number of wheels!");
        }

        this.kind = kind;
        this.numberOfTires = numberOfTires;

    }

    public Kind getKind() {
        return kind;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    @Override
    public String toString() {
        return kind + ", wheels: " + numberOfTires;
    }
}
