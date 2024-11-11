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
        System.out.println("You are traveling...");

        int userInput = scanner.nextInt();

        return true;
    }

}
