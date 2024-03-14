package com.mycompany.practice8;

import java.util.ArrayList;
import java.util.Scanner;

class Telephone implements Comparable<Telephone>{
    private String model;
    private String serialNumber;
    private String color;
    private boolean isMobile;

    public Telephone(String model, String serialNumber, String color, boolean isMobile) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.color = color;
        this.isMobile = isMobile;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getColor() {
        return color;
    }

    public boolean isMobile() {
        return isMobile;
    }

    @Override
    public String toString() {
        return model + ", " + serialNumber + ", " + color + ", " + isMobile;
    }
    
    @Override
    public int compareTo(Telephone o1){
        return getSerialNumber().compareTo(o1.serialNumber);
    }
}

public class Practice8 {
    public static void main(String[] args) {
        ArrayList<Telephone> telephoneList = new ArrayList<>();
        telephoneList.add(new Telephone("Panasonic", "X35235ZMD", "white", false));
        telephoneList.add(new Telephone("Samsung S10", "XYZ123456789", "black", true));
        telephoneList.add(new Telephone("Iphone X", "ASIOS77777QWERTY", "black", true));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Practical task 1.8, Student Korneev Arseniy, RIBO-04-22, Variant 2");
            System.out.println("Choose an option:");
            System.out.println("1. Add a telephone");
            System.out.println("2. Remove a telephone by serial number");
            System.out.println("3. Remove all telephones");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTelephone(scanner, telephoneList);
                    break;
                case 2:
                    removeTelephone(scanner, telephoneList);
                    break;
                case 3:
                    removeAllTelephones(telephoneList);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (choice != 3);
    }

    public static void addTelephone(Scanner scanner, ArrayList<Telephone> telephoneList) {
        System.out.println("Enter model:");
        String model = scanner.next();
        System.out.println("Enter serial number:");
        String serialNumber = scanner.next();
        System.out.println("Enter color:");
        String color = scanner.next();
        System.out.println("Is it mobile? (true/false):");
        boolean isMobile = scanner.nextBoolean();

        for (Telephone telephone : telephoneList) {
            if (telephone.getSerialNumber().equals(serialNumber)) {
                System.out.println("Telephone with this serial number already exists.");
                return;
            }
        }

        telephoneList.add(new Telephone(model, serialNumber, color, isMobile));
        System.out.println("Telephone added successfully.");
        displayTelephoneList(telephoneList);
    }

    public static void removeTelephone(Scanner scanner, ArrayList<Telephone> telephoneList) {
        System.out.println("Enter serial number of the telephone to remove:");
        String serialNumber = scanner.next();

        Telephone foundTelephone = null;
        for (Telephone telephone : telephoneList) {
            if (telephone.getSerialNumber().equals(serialNumber)) {
                foundTelephone = telephone;
                break;
            }
        }

        if (foundTelephone != null) {
            telephoneList.remove(foundTelephone);
            System.out.println("Telephone removed successfully.");
        } else {
            System.out.println("Telephone with this serial number not found.");
        }

        displayTelephoneList(telephoneList);
    }

    public static void removeAllTelephones(ArrayList<Telephone> telephoneList) {
        telephoneList.clear();
        System.out.println("All telephones removed successfully.");
    }

    public static void displayTelephoneList(ArrayList<Telephone> telephoneList) {
        telephoneList.sort(Telephone::compareTo);
        System.out.println("Current Telephone List:");
        for (Telephone telephone : telephoneList) {
            System.out.println(telephone);
        }
        System.out.println();
    }
}