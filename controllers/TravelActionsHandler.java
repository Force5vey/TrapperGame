package controllers;

import models.Player;
import models.Trap;
import utils.Graphics;
import java.util.Scanner;

public class TravelActionsHandler {

    private Scanner scanner;
    private Player player;
    private TrapManager trapManager;

    public TravelActionsHandler(Scanner scanner, Player player, TrapManager trapManager) {
        this.scanner = scanner;
        this.player = player;
        this.trapManager = trapManager;
    }

    public boolean travelingActions() {
        Trap destinationTrap = trapManager.getTrapByIndex(player.trapDestinationIndex);

        if (destinationTrap == null) {
            System.out.println("Invalid travel destination.");
            return false;
        }

        int distanceToTravel = destinationTrap.getDistanceFromHome();
        int traveledDistance = 0;
        String dots = "You are traveling .";

        for (int i = 0; i <= distanceToTravel; i++) {
            Graphics.clearScreen();
            Graphics.printStatusBar(player);

            player.TraveledDistance = traveledDistance;

            if (i % 100 == 0) {
                System.out.println("Travel Distance: [ " + player.traveledDistance + " / " + distanceToTravel + " ]");
                System.out.println();
                System.out.print(dots);

                dots += " .";

                try {
                    Thread.sleep(200);  // Adjust delay as needed for simulation effect
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            traveledDistance++;
        }

        System.out.println("Arrived at " + destinationTrap.getTrapName());
        return false;  // End traveling state after reaching destination
    }
}

