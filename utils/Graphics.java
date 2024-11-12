package utils;

import java.util.Scanner;
import models.*;
import controllers.*;
import utils.*;

public class Graphics
{

    public static void ClearScreen()
    {
        System.out.println("\033[H\033[2J");
    }

    public static void PrintStatusBar(Player player)
    {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.print("|  Health: [ " + player.GetCurrentHealth() + " / " + player.GetMaxHealth() + " ]  |  ");
        System.out.print("Water: [ " + player.GetCurrentWater() + " / " + player.GetMaxWater() + " ]  |  ");
        System.out.print("Food: [ " + player.GetCurrentFood() + " / " + player.GetMaxFood() + " ]  |  ");
        System.out.print("Ammo: [ " + player.GetCurrentAmmo() + " / " + player.GetMaxAmmo() + " ]  |  ");
       System.out.print("\n");
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public static void DisplayIntroNarrative(Scanner scanner, int width, String[] textToPrint)
    {
        String[] introText = textToPrint;
        int charPrintDelay = 5, printWidth = width;

        for (String paragraph : introText)
        {
            int lineLength = 0;

            for (int i = 0; i < paragraph.length(); i++)
            {
                char currentChar = paragraph.charAt(i);
                System.out.print(currentChar);

                lineLength++;

                if (lineLength >= printWidth && currentChar == ' ')
                {
                    System.out.print("\n");
                    lineLength = 0;
                }

                try
                {
                    Thread.sleep(charPrintDelay);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
            System.out.println("\n\n");
        }
        scanner.next();
    }

    public static void DisplayTitle(Scanner scanner)
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(GetTitleCard());

        try

        {
            Thread.sleep(500);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        int i = 0;
        while (i < 100)
        {
            System.out.println(" ");
            i++;

            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("\033[H\033[2J");
        System.out.println("\n\n\n\n\n");
        System.out.println(GetStartGameGraphic());

        scanner.next();
    }

    static public String GetStartGameGraphic()
    {
        String startGraphic = """
                ███████╗████████╗ █████╗ ██████╗ ████████╗     ██████╗  █████╗ ███╗   ███╗███████╗
                ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝
                ███████╗   ██║   ███████║██████╔╝   ██║       ██║  ███╗███████║██╔████╔██║█████╗
                ╚════██║   ██║   ██╔══██║██╔══██╗   ██║       ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝
                ███████║   ██║   ██║  ██║██║  ██║   ██║       ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗
                ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝        ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝

                                               (ENTER 's' TO START)
                            """;

        return startGraphic;

    }

    static public String GetTitleCard()
    {
        String title = """
                          ███████████ ███████████    █████████  ███████████  ███████████  ██████████ ███████████
                         ░█░░░███░░░█░░███░░░░░███  ███░░░░░███░░███░░░░░███░░███░░░░░███░░███░░░░░█░░███░░░░░███
                         ░   ░███  ░  ░███    ░███ ░███    ░███ ░███    ░███ ░███    ░███ ░███  █ ░  ░███    ░███     ██
                             ░███     ░██████████  ░███████████ ░██████████  ░██████████  ░██████    ░██████████     ░░
                             ░███     ░███░░░░░███ ░███░░░░░███ ░███░░░░░░   ░███░░░░░░   ░███░░█    ░███░░░░░███
                             ░███     ░███    ░███ ░███    ░███ ░███         ░███         ░███ ░   █ ░███    ░███
                             █████    █████   ██████████   ██████████        █████        ██████████ █████   █████    ██
                            ░░░░░    ░░░░░   ░░░░░░░░░░   ░░░░░░░░░░        ░░░░░        ░░░░░░░░░░ ░░░░░   ░░░░░    ░░



                 █████   ██████████  █████  █████████  █████   █████      █████████  █████        █████████    █████████  █████████
                ░░███   ░░███░░███  ░░███  ███░░░░░███░░███   ░░███      ███░░░░░███░░███        ███░░░░░███  ███░░░░░██████░░░░░███
                 ░███    ░███ ░███   ░███ ███     ░░░  ░███    ░███     ███     ░░░  ░███       ░███    ░███ ░███    ░░░░███    ░░░
                 ░███████████ ░███   ░███░███          ░███████████    ░███          ░███       ░███████████ ░░█████████░░█████████
                 ░███░░░░░███ ░███   ░███░███    █████ ░███░░░░░███    ░███    █████ ░███       ░███░░░░░███  ░░░░░░░░███░░░░░░░░███
                 ░███    ░███ ░███   ░███░░███  ░░███  ░███    ░███    ░░███  ░░███  ░███      █░███    ░███  ███    ░██████    ░███
                 █████   █████░░████████  ░░█████████  █████   █████    ░░█████████  ████████████████   █████░░█████████░░█████████
                ░░░░░   ░░░░░  ░░░░░░░░    ░░░░░░░░░  ░░░░░   ░░░░░      ░░░░░░░░░  ░░░░░░░░░░░░░░░░   ░░░░░  ░░░░░░░░░  ░░░░░░░░░



                                                █████████   █████████    █████████   █████████
                                               ███░░░░░███ ███░░░░░███  ███░░░░░███ ███░░░░░███
                                              ░███    ░░░ ░███    ░███ ███     ░░░ ░███    ░███
                                              ░░█████████ ░███████████░███         ░███████████
                                               ░░░░░░░░███░███░░░░░███░███    █████░███░░░░░███
                                               ███    ░███░███    ░███░░███  ░░███ ░███    ░███
                                              ░░█████████ █████   █████░░█████████ █████   █████
                                               ░░░░░░░░░ ░░░░░   ░░░░░  ░░░░░░░░░ ░░░░░   ░░░░░
                                           """;

        return title;
    }

    static public String[] GetIntroNarrative()
    {
        String[] paragraphs =
        { "Through the mists of time and blood-soaked legend, you've become the ghost of the wilds. "
                + "You are Hugh Glass, a name spoken in whispers-a trapper, a survivor, a man who clawed his way back from "
                + "the edge of death itself. Once left for dead after a brutal mauling by a grizzly, you dragged your "
                + "battered body across miles of unforgiving wilderness. Vengeance may have healed the scars of the past, "
                + "but in this lonely expanse of South Dakota, the land itself has no mercy.",

                "The season is turning; frost clings to the air and the forest grows silent, watchful. Winter is a "
                        + "predator, lurking at the edge of the coming days. In this vast wilderness, survival means preparation, and "
                        + "each step you take could be the one that keeps you alive-or the one that seals your fate.",

                "Tonight, you check your traps. The woods are still, but stillness here does not mean peace. You feel "
                        + "it-a quiet unease, like eyes watching from the treeline, the endless echoes of the wilderness reminding you "
                        + "that it owes no debts to man. Food is scarce, the cold merciless. Each trap holds the promise of survival, "
                        + "but you know too well that every journey has its own snare. "
                        + "Will the land claim you, or will you master its secrets once again?" };

        return paragraphs;
    }

    static public String GetTreeArt()
    {
        String tree = """
                          &&& &&  & &&
                      && &\\/&\\|& ()|/ @, &&
                      &\\/(/&/&||/& /_/)_&/_&
                   &() &\\/&|()|/&\\/ '%" & ()
                  &_\\_&&_\\ |& |&&/&__%_/_& &&
                &&   && & &| &| /& & % ()& /&&
                 ()&_---()&\\&\\|&&-&&--%---()~
                     &&     \\|||
                             |||
                             |||
                             |||
                       , -=-~  .-^- _
                               """;

        return tree;
    }

}
