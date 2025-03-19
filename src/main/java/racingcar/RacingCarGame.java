package racingcar;

import java.util.List;

import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarResultView;

public class RacingCarGame {

    public static void start() {
        RacingCarInput input = RacingCarInputView.view();
        List<RacingCar> racingCars = RacingCar.createRacingCars(input.getCarCount());

        for (int i = 0; i < input.getTryCount(); i++) {
            RacingCarGame.moveIfMovable(racingCars);
            RacingCarResultView.view(racingCars);
        }
    }

    private static void moveIfMovable(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            car.moveIfMovable();
        }
    }

}
