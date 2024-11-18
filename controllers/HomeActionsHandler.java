package controllers;

import java.util.Scanner;
import models.*;
import utils.*;

public class HomeActionsHandler
{
    private Scanner scanner;
    private Player player;
    private Trap[] traps;

    // Constructor
    public HomeActionsHandler(Scanner scanner, Player player, Trap[] traps)
    {
        this.scanner = scanner;
        this.player = player;
        this.traps = traps;
    }

    public boolean PerformHomeActions()
    {
        boolean atHome = true;

        int userSelection = 0;

        while (atHome)
        {
            Graphics.ClearScreen();

            Graphics.PrintStatusBar(player);

            System.out.println("========================\n|        CABIN         |\n========================");
            System.out.println();

            System.out.println("[1] Process Game");
            System.out.println("[2] Rest");
            System.out.println("[3] Check Traps");
            System.out.println(" ------------ ");
            System.out.println("[9] Exit Game");

            if (scanner.hasNextInt())
            {
                userSelection = scanner.nextInt();

                switch (userSelection) {
                case 1:
                    // process game

                    if (player.GetHasAnimal())
                    {
                        System.out.print("Processing Game");
                        for (int i = 0; i < player.ProcessDuration; i++)
                        {
                            System.out.print(" .");
                            try
                            {
                                Thread.sleep(1000);
                            } catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }

                        }
                        player.ProcessAnimal();
                    } else
                    {
                        System.out.print("No animal to process");
                        for (int i = 0; i < 5; i++)
                        {
                            System.out.print(" .");

                            try
                            {
                                Thread.sleep(500);
                            } catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }

                    break;
                case 2:
                    System.out.print("Resting");

                    for (int i = 0; i < player.RestDuration; i++)
                    {
                        System.out.print(" .");

                        player.Rest();

                        try
                        {
                            Thread.sleep(1000);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    // This will allow to select which trap, set current
                    // location to
                    // traveling. and destination to the trap of choice
                    //

                    System.out.println("To which trap do you wish to travel?");
                    for (int i = 0; i < traps.length; i++)
                    {
                        System.out.println("[" + (i + 1) + "] " + traps[0].GetTrapName());
                    }

                    System.out.println("\nEnter selection...");

                    if (scanner.hasNextInt())
                    {
                        int userSubSelection = scanner.nextInt();

                        userSubSelection -= 1; // adjsut from selection to traps
                                               // index

                        player.SetCurrentLocation(Player.Location.Traveling);
                        player.SetDestination(traps[userSubSelection].GetTrapLocation());
                        player.TrapDestinationIndex = userSubSelection;
                        player.SetTotalTravelDistance(traps[userSubSelection].GetDistanceFromHome());
                        atHome = false;
                    }
                    break;
                case 9:
                    // Exit Game
                    atHome = false;
                    return false;
                }
            } else
            {
                atHome = true;
            }

            // scanner.nextLine();
        }

        return true;
    }
}
