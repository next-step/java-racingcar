package javaracingcar.view;

import javaracingcar.entity.RacingCar;

import java.util.List;

public class ResultView {

    private static final String DEFAULT_MESSAGE = "실행결과";

    private ResultView() {
    }

    public static void resultStartMessage() {
        System.out.println(DEFAULT_MESSAGE);
    }

    public static void printResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            for (int i = 0; i < racingCar.moveCount(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
