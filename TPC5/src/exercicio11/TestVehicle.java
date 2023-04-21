package exercicio11;
public class TestVehicle {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("SV-93-GB", "EQUINOX", 2004, 50000);
        System.out.println("Registration number: " + vehicle.getRegNo());
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Year of manufacture: " + vehicle.getYearOfManufacture());
        System.out.println("Value: " + vehicle.getValue());
        System.out.println("Age: " + vehicle.calculateAge(2023));

        System.out.println("------------------------------------------------");

        SecondHandVehicle secondHandVehicle = new SecondHandVehicle("SV-18-DZ", "4X4", 1903, 100000, 2);
        System.out.println("Registration number: " + secondHandVehicle.getRegNo());
        System.out.println("Make: " + secondHandVehicle.getMake());
        System.out.println("Year of manufacture: " + secondHandVehicle.getYearOfManufacture());
        System.out.println("Value: " + secondHandVehicle.getValue());
        System.out.println("Age: " + secondHandVehicle.calculateAge(2023));
        System.out.println("Number of owners: " + secondHandVehicle.getNumberOfOwners());
        System.out.println("Has multiple owners: " + secondHandVehicle.hasMultipleOwners());
    }
}

