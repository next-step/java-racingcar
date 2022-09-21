package racingcar.model;

import racingcar.RacingCar;

import java.util.List;

public class ResultView {

    public static void print(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> System.out.println("-".repeat(racingCar.currentPosition())));
        System.out.println();
    }
}
