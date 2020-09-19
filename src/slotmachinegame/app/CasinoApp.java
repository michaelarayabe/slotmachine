package slotmachinegame.app;

import slotmachinegame.model.SlotMachine;
import slotmachinegame.view.Identifier;
import slotmachinegame.view.Menu;

public class CasinoApp {

    public static void main(String[] args) {

        SlotMachine slotMachine1 = new SlotMachine();

        Identifier.identifyUser();
        while(true){
            boolean userChoice = Menu.askUserIfWantsToPlay();

            if(userChoice){
                slotMachine1.playSlot();
                System.out.println("User wants to play");
            } else{
                System.out.println("user doesn't want to play");
                break;
            }
        }
    }
}
