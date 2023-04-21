package exercicio11;
public class SecondHandVehicle extends Vehicle {
    private int numberOfOwners;

    public SecondHandVehicle(String regNo, String make, int yearOfManufacture, double value, int numberOfOwners) {
        super(regNo, make, yearOfManufacture, value);
        this.numberOfOwners = numberOfOwners;
    }
    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    public boolean hasMultipleOwners() {
        return numberOfOwners > 1;
    }
}
