package view;

import java.util.List;

import model.RacingCar;

public class OutputView {

    private static final String MOVEMENT_INDICATOR = "-";

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(final List<RacingCar> racingCars) {
        for (final RacingCar racingCar : racingCars) {
            System.out.println(MOVEMENT_INDICATOR.repeat(racingCar.getLocation()));
        }
        System.out.println();
    }
}
