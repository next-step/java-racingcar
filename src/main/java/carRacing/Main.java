package carRacing;

import carRacing.Controller.InGameController;
import carRacing.Controller.ResultGameController;


public class Main {
    public static void main(String[] args) {
        InGameController inGameController = InGameController.run();
        ResultGameController resultGameController = ResultGameController.init();

        for (int i = 0; i < inGameController.getTime(); i++) {
            resultGameController.showGameState(inGameController.move());
        }


    }
}
