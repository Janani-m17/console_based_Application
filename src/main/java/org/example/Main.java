package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Simple Calculator Application (+-*/)");
            System.out.println("Choose Operation : \n1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exit");

            try {
                System.out.println("Enter your choice: ");
                int operation = s.nextInt();

                if (operation == 5) {
                    System.out.println("Exiting the program");
                    break;
                }

                System.out.println("Enter first number: ");
                int num1 = s.nextInt();

                System.out.println("Enter second number: ");
                int num2 = s.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Result: " + (num1+num2));
                        break;
                    case 2:
                        System.out.println("Result: " + (num1-num2));
                        break;
                    case 3:
                        System.out.println("Result: " + (num1*num2));
                        break;
                    case 4:
                        if (num2 != 0) {
                            System.out.println("Result: Quotient: " + ((double) num1/num2));
                            System.out.println("Remainder: " + ((double)num1%num2));
                        } else {
                            System.out.println("Error: Division by zero.");
                        }
                        break;
                    default:
                        System.out.println("Enter a valid operation number.");
                }

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
}
