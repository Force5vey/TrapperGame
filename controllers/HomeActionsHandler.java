package controllers;

import java.util.Scanner;
import models.Player;
import models.Trap;
import utils.Graphics;

public class HomeActionsHandler {

    private Scanner scanner;
    private Player player;
    private TrapManager trapManager;

    public HomeActionsHandler(Scanner scanner, Player player, TrapManager trapManager) {
        this.scanner = scanner;
        this.player = player;
        this.trapManager = trapManager;
    }

    public boolean performHomeActions() {
        boolean atHome = true;

        while (atHome) {
            Graphics.clearScreen();
            Graphics.printStatusBar(player);

            System.out.println("========================\n|        CABIN         |\n========================");
            System.out.println("[1] Process Game");
            System.out.println("[2] Rest");
            System.out.println("[3] Check Traps");
            System.out.println(" ------------ ");
            System.out.println("[9] Exit Game");

            if (scanner.hasNextInt()) {
                int userSelection = scanner.nextInt();
                switch (userSelection) {
                    case 1 -> processGame();
                    case 2 -> rest();
                    case 3 -> checkTraps();
                    case 9 -> atHome = false;
                    default -> System.out.println("Invalid option.");
                }
            }
        }
        return atHome;
    }

    private void processGame() {
        if (player.getHasAnimal()) {
            System.out.print("Processing Game");
            for (int i = 0; i < player.getProcessDuration(); i++) {
                System.out.print(" .");
                try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            System.out.println("\nGame processed.");
            player.setHasAnimal(false); // Reset animal status after processing
        } else {
            System.out.println("No animal to process.");
        }
    }

    private void rest() {
        System.out.println("Resting...");
        player.rest();
    }

    private void checkTraps() {
        for (Trap trap : trapManager.getAllTraps()) {
            System.out.println("Trap at " + trap.getTrapName() + " is " + (trap.isSet() ? "set" : "not set"));
        }
    }
}

