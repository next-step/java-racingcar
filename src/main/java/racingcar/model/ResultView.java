package racingcar.model;

import racingcar.RacingCarList;

public class ResultView {

    public static void print(RacingCarList racingCars) {
        racingCars.currentRacingCars().forEach(racingCar -> System.out.println("-".repeat(racingCar.currentPosition())));
        System.out.println();
    }
}
