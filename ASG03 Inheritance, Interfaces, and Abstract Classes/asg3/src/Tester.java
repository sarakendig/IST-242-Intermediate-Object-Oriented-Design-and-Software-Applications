import java.time.Year;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Manufacturer ford = new Manufacturer("Ford", "USA");
        AutoModel f150Model = new AutoModel("F-150", true, List.of(Year.of(2020), Year.of(2021), Year.of(2022)));
        Truck f150Truck = new Truck(ford, f150Model, false, 20.00);

        Manufacturer honda = new Manufacturer("Honda", "Japan");
        AutoModel civicModel = new AutoModel("Civic LX", false, List.of(Year.of(1996), Year.of(1997), Year.of(1998)));
        Sedan civicSedan = new Sedan(honda, civicModel, 28.00);

        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        AutoModel m3Model = new AutoModel("M3 Limited", false, List.of(Year.of(2015), Year.of(2016), Year.of(2017), Year.of(2018)));
        Sedan m3Sedan = new Sedan(bmw, m3Model, 30.00);

        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        AutoModel tundraModel = new AutoModel("Tundra", false, List.of(Year.of(1987), Year.of(1988)));
        Truck tundraTruck = new Truck(toyota, tundraModel, true, 30.00);

        Garage garage = new Garage();
        garage.addVehicle(f150Truck);
        garage.addVehicle(civicSedan);
        garage.addVehicle(m3Sedan);
        garage.addVehicle(tundraTruck);

        System.out.println("Before sorting: ");
        System.out.println(garage);

        garage.sortGarage();

        System.out.println("After sorting: ");
        System.out.println(garage);
    }
}