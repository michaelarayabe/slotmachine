package slotmachinegame.view;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    public static boolean askUserIfWantsToPlay(){

        while(true) {
            System.out.println("Do you want to play? 'yes/no'");
            String userChoice = scanner.next();

            if (userChoice.equalsIgnoreCase("yes")) {
                return true;

            } else if (userChoice.equalsIgnoreCase("no")) {
                return false;

            } else{
                System.out.println("input valid input");
            }
        }

    }
}
