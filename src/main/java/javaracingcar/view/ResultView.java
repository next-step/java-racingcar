package javaracingcar.view;

import javaracingcar.entity.RacingCar;

import java.util.List;

public class ResultView {

    private static final String DEFAULT_MESSAGE = "실행결과";
    private static final String DEFAULT_MOVE_UNIT = "-";

    private ResultView() {
    }

    public static void resultStartMessage() {
        System.out.println(DEFAULT_MESSAGE);
    }

    public static void endRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            viewCurrentCarLocation(racingCar);
        }
        System.out.println();
    }

    private static void viewCurrentCarLocation(RacingCar racingCar) {
        for (int i = 0; i < racingCar.moveCount(); i++) {
            System.out.print(DEFAULT_MOVE_UNIT);
        }
        System.out.println();
    }
}
