package exercicio11;

import exercicio11.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 4) {
            System.out.println("1 - Adicionar Veiculo");
            System.out.println("2 - Listar Veiculo");
            System.out.println("3 - Apagar  Veiculo");
            System.out.println("4 - Terminar");
            System.out.print("Insira sua escolha: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1) {
                    adicionarVehicle();
                } else if (choice == 2) {
                    listarVehicles();
                } else if (choice == 3) {
                    apagarVehicle();
                } else if (choice == 4) {
                    System.out.println("Terminar...");
                } else {
                    System.out.println("Digita apenas numeros 1 a 4.");
                }
            }
        }
    }
    private static void adicionarVehicle() {
        System.out.print("Digita placa do veiculo: ");
        String regNo = scanner.nextLine();
        System.out.print("Dgita a marca: ");
        String make = scanner.nextLine();
        System.out.print("Digita o ano fabrico: ");
        int yearOfManufacture = scanner.nextInt();
        System.out.print("Digita valor do veiculo: ");
        double value = scanner.nextDouble();
        System.out.print("Digite o número de proprietários: ");
        int numberOfOwners = scanner.nextInt();

        SecondHandVehicle secondHandVehicle = new SecondHandVehicle(regNo, make, yearOfManufacture, value, numberOfOwners);
        vehicles.add(secondHandVehicle);
    }
    private static void listarVehicles() {
        System.out.println("lista de veiculos");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Registration number: " + vehicle.getRegNo());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Year of manufacture: " + vehicle.getYearOfManufacture());
            System.out.println("Value: " + vehicle.getValue());
            if (vehicle instanceof SecondHandVehicle) {
                SecondHandVehicle secondHandVehicle = (SecondHandVehicle) vehicle;
                System.out.println("Number of owners: " + secondHandVehicle.getNumberOfOwners());
                System.out.println("Has multiple owners: " + secondHandVehicle.hasMultipleOwners());
            }
            System.out.println();
        }
    }

    private static void apagarVehicle() {
        System.out.print("Insira a matrícula do veículo a eliminar:");
        String regNo = scanner.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegNo().equals(regNo)) {
                vehicles.remove(vehicle);
                return;
            }
        }

        System.out.println("exercicio11.Vehicle not found.");
    }
}
