package racingcargame;

import racingcargame.controller.RacingCarGameController;
import racingcargame.model.RacingCar;

import java.util.List;

public class RacingCarGameMain {
    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController();

        List<RacingCar> racingCars = controller.getRacingCars();
        int roundNumber = controller.getRoundNumber();
        controller.runGame(racingCars, roundNumber);
        controller.getResult(racingCars);
    }
}
