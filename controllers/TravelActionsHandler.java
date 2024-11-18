package controllers;

import models.*;
import utils.*;

import java.util.Scanner;

public class TravelActionsHandler
{
    Scanner scanner;
    Player player;
    Trap[] traps;

    public TravelActionsHandler(Scanner scanner, Player player, Trap[] traps)
    {
        this.scanner = scanner;
        this.player = player;
        this.traps = traps;

    }

    public boolean TravelingActions()
    {

        int distanceToTravel = traps[player.TrapDestinationIndex].GetDistanceFromHome();
        int traveledDistance = 0;

        String dots = "You are traveling .";

        for (int i = 0; i <= distanceToTravel; i++)
        {
            Graphics.ClearScreen();
            Graphics.PrintStatusBar(player);

            player.TraveledDistance = traveledDistance;

            if (i % 100 == 0)
            {
                System.out.println("Travel Distance: [ " + player.TraveledDistance + " / " + player.TotalTravelDistance
                        + " ]  |  ");
                System.out.println();
                System.out.print(dots);

                dots += " .";

                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            traveledDistance++;
        }

        int userInput = scanner.nextInt();

        return true;
    }

}
