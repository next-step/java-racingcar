package view;

import java.util.List;

import model.RacingCar;

public class OutputView {
    
    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(final List<RacingCar> racingCars) {
        for (final RacingCar racingCar : racingCars) {
            for (int i = 0; i < racingCar.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
