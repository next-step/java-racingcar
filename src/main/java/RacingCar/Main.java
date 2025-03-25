package RacingCar;

import NumberGenerator.*;
import RacingCar.controller.RacingCarController;
import RacingCar.model.RacingCar;
import RacingCar.model.RacingCars;
import RacingCar.view.RacingCarView;

public class Main {
    public static void main(String args[]) {
        final int MOVE_CONDITION = 4;
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingCarView view = new RacingCarView();

        String[] carNames = view.scanCarNames();
        int tryNum = view.scanTryNum();

        RacingCars cars = new RacingCars(carNames, MOVE_CONDITION, numberGenerator);

        RacingCarController controller = new RacingCarController(cars, view, tryNum);
        controller.startRace();
    }
}
