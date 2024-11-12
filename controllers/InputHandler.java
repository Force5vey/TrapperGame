package controllers;

import java.util.Scanner;

public class InputHandler {

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public char getNextAction() {
        System.out.print("Enter action (h for home, t for travel, c for combat): ");
        while (scanner.hasNext()) {
            String input = scanner.next().toLowerCase();
            if (!input.isEmpty()) {
                char action = input.charAt(0);
                if (action == 'h' || action == 't' || action == 'c') {
                    return action;
                } else {
                    System.out.println("Invalid input. Please enter 'h', 't', or 'c'.");
                }
            }
        }
        return 'h';  // Default action to home
    }
}

