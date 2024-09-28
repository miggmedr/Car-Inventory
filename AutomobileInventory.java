package CarInventory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        try {
            Automobile2 car1 = new Automobile2("Toyota", "Camry", "White", 2016, 45000);

            String[] info = car1.listVehicleInfo();
            System.out.println("Vehicle Information:");
            for (String detail : info) {
                System.out.println(detail);
            }


            Automobile2 car2 = new Automobile2("Mercedes","Cla250","Black",2020,43000);
            info = car2.listVehicleInfo();
            System.out.println("Second vehicle information:");
            for (String detail : info){
                System.out.println(detail);
            }


            String removeResult = car1.removeVehicle();
            System.out.println(removeResult);

            info = car1.listVehicleInfo();
            System.out.println("Vehicle Information After Removal:");
            for (String detail : info) {
                System.out.println(detail);
            }

            String addResult = car1.addVehicle("Honda", "Civic", "Black", 2005, 120000);
            System.out.println(addResult);

            info = car1.listVehicleInfo();
            System.out.println("New Vehicle Information:");
            for (String detail : info) {
                System.out.println(detail);
            }

            String updateResult = car1.updateVehicle("Honda", "Accord", "Blue", 2010, 90000);
            System.out.println(updateResult);

            info = car1.listVehicleInfo();
            System.out.println("Updated Vehicle Information:");
            for (String detail : info) {
                System.out.println(detail);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to print the information to a file (Y/N)? ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                printToFile(info, "C:\\Temp\\Autos.txt");
            } else {
                System.out.println("File will not be printed.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void printToFile(String[] info, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String detail : info) {
                writer.write(detail + "\n");
            }
            System.out.println("Information printed to file successfully.");
        } catch (IOException e) {
            System.out.println("Error printing to file: " + e.getMessage());
        }
    }
}


