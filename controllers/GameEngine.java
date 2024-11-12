package controllers;

import java.util.Scanner;
import models.Player;
import models.Location;
import utils.Graphics;

public class GameEngine {

    private Scanner scanner;
    private boolean isRunning = true;

    private Player player;
    private TrapManager trapManager;
    private HomeActionsHandler homeActionsHandler;
    private TravelActionsHandler travelActionsHandler;
    private InputHandler inputHandler;

    private enum GameState { HOME, TRAVELING, COMBAT }
    private GameState gameState;

    public GameEngine() {
        initializeGame();
    }

    private void initializeGame() {
        scanner = new Scanner(System.in);
        player = new Player();
        trapManager = new TrapManager();
        
        homeActionsHandler = new HomeActionsHandler(scanner, player, trapManager);
        travelActionsHandler = new TravelActionsHandler(scanner, player, trapManager);
        inputHandler = new InputHandler(scanner);
        
        gameState = GameState.HOME;
    }

    public void Start() {
        while (isRunning) {
            Graphics.clearScreen();
            Graphics.printStatusBar(player);

            switch (gameState) {
                case HOME:
                    isRunning = homeActionsHandler.performHomeActions();
                    break;
                case TRAVELING:
                    isRunning = travelActionsHandler.travelingActions();
                    break;
                case COMBAT:
                    isRunning = handleCombat();
                    break;
                default:
                    isRunning = false;
            }

            gameState = determineNextState();
        }
    }

    private boolean handleCombat() {
        System.out.println("Combat state handling goes here...");
        return true;  // Placeholder, adjust based on game requirements
    }

    private GameState determineNextState() {
        char choice = inputHandler.getNextAction();
        return switch (choice) {
            case 'h' -> GameState.HOME;
            case 't' -> GameState.TRAVELING;
            case 'c' -> GameState.COMBAT;
            default -> GameState.HOME;
        };
    }
}

