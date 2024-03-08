package view;

import java.util.List;

import model.RacingCar;

public class OutputView {

    public void printResult(final List<RacingCar> racingCars) {
        System.out.println("실행 결과");
        for (final RacingCar racingCar : racingCars) {
            for (int i = 0; i < racingCar.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
