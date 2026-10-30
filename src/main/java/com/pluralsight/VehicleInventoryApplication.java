package com.pluralsight;

import java.util.Scanner;

public class VehicleInventoryApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle[] vehicles = new Vehicle[20];
        int vehicleCount = 0;

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicleCount++;
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicleCount++;
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicleCount++;
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicleCount++;
        vehicles[4] = new Vehicle(101125, "Subaru Outback" ,"Green" ,55000 , 14500);
        vehicleCount++;
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
        vehicleCount++;

        boolean running = true;

        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.print("Enter your command: ");

            int command = Integer.parseInt(scanner.nextLine().trim());

            switch (command) {
                case 1:
                    listAllVehicles(vehicles, vehicleCount);
                    break;
                case 2:
                    findVehiclesByMakeModel(vehicles, vehicleCount, scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Option not available yet.");

            }
        }


    }
    public static void listAllVehicles(Vehicle[] vehicles, int count) {

        for(int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            System.out.println(v.getVehicleId() + " | " + v.getMakeModel() + " | " + v.getColor() + " | " + v.getOdometerReading() + " miles | $" + v.getPrice());

        }

    }
    public static void findVehiclesByMakeModel(Vehicle[] vehicles, int count, Scanner scanner) {
        System.out.print("Enter make/model to search: ");
        String search = scanner.nextLine().trim().toLowerCase();

        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            if (v.getMakeModel().toLowerCase().contains(search)) {
                System.out.println(v.getVehicleId() + " | " + v.getMakeModel() + " | " + v.getColor() + " | " + v.getOdometerReading() + " miles | $" + v.getPrice());

            }
        }
    }
}
