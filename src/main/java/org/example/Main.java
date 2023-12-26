package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();

            try {
                int operation = s.nextInt();

                if (operation == 5) {
                    System.out.println("Exiting the program");
                    break;
                }

                System.out.println("Enter first number: ");
                int num1 = s.nextInt();

                System.out.println("Enter second number: ");
                int num2 = s.nextInt();

                performOperation(operation,num1,num2);

                System.out.println("Do you want to continue? (yes/no): ");
                String yesno = s.next().toLowerCase();

                if (!yesno.equals("yes")) {
                    System.out.println("Exiting the program");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
                s.next();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Simple Calculator Application (+-*/)");
        System.out.println("Choose Operation : \n1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exit");
        System.out.println("Enter your choice: ");
    }

    private static void performOperation(int operation,int num1,int num2) {
        switch (operation) {
            case 1:
                System.out.println("Result: " + add(num1,num2));
                break;
            case 2:
                System.out.println("Result: " + subtract(num1,num2));
                break;
            case 3:
                System.out.println("Result: " + multiply(num1,num2));
                break;
            case 4:
                divide(num1,num2);
                break;
            default:
                System.out.println("Enter a valid operation number.");
        }
    }

    private static int add(int a,int b) {
        return a+b;
    }

    private static int subtract(int a,int b) {
        return a-b;
    }

    private static int multiply(int a,int b) {
        return a*b;
    }

    private static void divide(int a,int b) {
        if (b != 0) {
            System.out.println("Result: Quotient: " + ((double)a/b));
            System.out.println("Remainder: " + ((double)a%b));
        } else {
            System.out.println("Error: Division by zero.");
        }
    }
}
