package utils;

import models.Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graphics {

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
    }

    public static void printStatusBar(Player player) {
        System.out.println("--------------------------------------------------");
        System.out.printf("| Health: %d / %d | Water: %d / %d | Food: %d / %d | Ammo: %d / %d |\n",
                          player.getCurrentHealth(), player.getMaxHealth(),
                          player.getCurrentWater(), player.getMaxWater(),
                          player.getCurrentFood(), player.getMaxFood(),
                          player.getCurrentAmmo(), player.getMaxAmmo());
        System.out.println("--------------------------------------------------");
    }

    public static void displayFromFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    public static void displayIntroNarrative(String filePath) {
        displayFromFile(filePath);
    }
}

