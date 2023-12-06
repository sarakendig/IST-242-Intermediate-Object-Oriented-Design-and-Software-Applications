package assignments.asg2;

import java.time.Year;
import java.util.ArrayList;

public class Tester {
    
    public static void main(String[] args) {
        // Creating Manufacturer, Model, and VehicleType objects
        Manufacturer ford = new Manufacturer("Ford", "USA");
        Manufacturer honda = new Manufacturer("Honda", "Japan");
        Manufacturer bmw = new Manufacturer("BMW", "Germany");

        ArrayList<Year> fordYears = new ArrayList<>();
        fordYears.add(Year.of(1975));
        Model f150Model = new Model("F150", false, fordYears);

        ArrayList<Year> hondaYears = new ArrayList<>();
        hondaYears.add(Year.of(1996));
        Model civicModel = new Model("Civic", false, hondaYears);

        ArrayList<Year> bmwYears = new ArrayList<>();
        bmwYears.add(Year.of(2003));
        Model m3Model = new Model("M3", false, bmwYears);

        VehicleType f150Type = new VehicleType(VehicleType.Kind.TRUCK, 4);
        VehicleType civicType = new VehicleType(VehicleType.Kind.SEDAN, 4);
        VehicleType m3Type = new VehicleType(VehicleType.Kind.COUPE, 4);

        // Creating Vehicle objects
        Vehicle f150 = new Vehicle(f150Model, ford, f150Type, 100000.0, 15.0);
        Vehicle civic = new Vehicle(civicModel, honda, civicType, 80000.0, 30.0);
        Vehicle m3 = new Vehicle(m3Model, bmw, m3Type, 60000.0, 20.0);

        // Printing the details of the Vehicle objects
        System.out.println("1.\n" + f150.toString() + "\n");
        System.out.println("2.\n" + civic.toString() + "\n");
        System.out.println("3.\n" + m3.toString());
    }
    }
