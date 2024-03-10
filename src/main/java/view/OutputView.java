package view;

import java.util.List;

import model.RacingCar;

public class OutputView {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(final List<RacingCar> racingCars) {
        for (final RacingCar racingCar : racingCars) {
            System.out.println(racingCar.generateStatus());
        }
        System.out.println();
    }
}
