package controllers;

import java.util.Scanner;
import utils.*;
import models.*;

public class GameEngine
{
    private Scanner scanner;

    // Game status
    static boolean isRunning = true;

    private Trap[] traps;
    private Player player;

    private HomeActionsHandler homeActionsHandler;
    private TravelActionsHandler travelActionsHandler;

    public GameEngine()
    {
        InitializeGame();
    }

    private void InitializeGame()
    {
        scanner = new Scanner(System.in);

        player = new Player();
        traps = new Trap[3];

        traps[0] = new Trap(Player.Location.BlackRiverBend);
        traps[0].TrapsIndex = 0;
        traps[1] = new Trap(Player.Location.RavenFelds);
        traps[1].TrapsIndex = 1;
        traps[2] = new Trap(Player.Location.WhisperingStone);
        traps[2].TrapsIndex = 2;

        homeActionsHandler = new HomeActionsHandler(scanner, player, traps);
        travelActionsHandler = new TravelActionsHandler(scanner, player, traps);

    }

    public void Start()
    {
        Graphics.DisplayTitle(scanner);

        Graphics.ClearScreen();
        System.out.println(Graphics.GetTreeArt());
        Graphics.DisplayIntroNarrative(scanner, 80, Graphics.GetIntroNarrative());

        System.out.println("'c' to continue..."); // make this enter to
                                                  // continue, needs to
                                                  // recognize 'any' key
        scanner.nextLine();

        StartGameLoop();
    }

    private void StartGameLoop()
    {
        // Debug / Testing
        Animal gameAnimal = new Animal(Animal.AnimalType.Deer, false);
        player.PickUpAnimal(gameAnimal);
        player.SubtractHealth(20);
        // /Debug / Testing

        // ** Pre Test Loop: While(condition)
        // This loop will check the boolean value isRunning
        // prior to executing code in the block.
        // As of now, this bool is set at class initialization to true
        // and there are no methods of checking and changing this value
        // inside GameEngine class. However, I am keeping it as a
        // pretest so that as my game expands, I can ensure the game loop
        // doesn't start if some other case results in changing the value
        // of isRunning to false.

        while (isRunning)
        {
            switch (player.GetCurrentLocation()) {
            case Home:
                isRunning = homeActionsHandler.PerformHomeActions();
                break;
            case Traveling:
                isRunning = travelActionsHandler.TravelingActions();
                break;
            case WhisperingStone:
                break;
            case RavenFelds:
                break;
            case BlackRiverBend:
                break;

            }

        }
    }
}
