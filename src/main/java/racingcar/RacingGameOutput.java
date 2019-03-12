package racingcar;

import java.util.List;

public class RacingGameOutput {

    public static void showRacingGame(List<RacingCar> racingCars) {
        racingCars.forEach(RacingCar::printPosition);
        System.out.println();
    }
}
