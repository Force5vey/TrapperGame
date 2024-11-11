package utils;

import java.util.Scanner;
import models.*;
import controllers.*;

public class GameEngine
{
    private Scanner scanner;

    // Game status
    static boolean isRunning = true;

    private Trap[] traps;
    private Player player;

    private HomeActionsHandler homeActionsHandler;

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

    }

    public void Start()
    {
        // Graphics.DisplayTitle(scanner);

        // Graphics.ClearScreen();
        // System.out.println(Graphics.GetTreeArt());
        // Graphics.DisplayIntroNarrative(scanner, 80,
        // Graphics.GetIntroNarrative());

        System.out.println("'c' to continue...");
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

        while (isRunning)
        {
            switch (player.GetCurrentLocation()) {
            case Home:
                isRunning = homeActionsHandler.PerformHomeActions();
                break;
            case Traveling:
                isRunning = TravelingActions();
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

    private boolean TravelingActions()
    {

        return true;
    }

}
