package carRacing;

import carRacing.Controller.InGameController;
import carRacing.Controller.ResultGameController;
import carRacing.Domain.Vehicles;


public class Main {
    public static void main(String[] args) {
        InGameController inGameController = InGameController.init();
        ResultGameController resultGameController = ResultGameController.init();

        Vehicles vehicles = inGameController.register();
        resultGameController.showGameState(vehicles);

        for (int i = 0; i < inGameController.getTime(); i++) {
            vehicles = inGameController.move(vehicles);
            resultGameController.showGameState(vehicles);
        }

        resultGameController.showWinner(vehicles);
    }
}
