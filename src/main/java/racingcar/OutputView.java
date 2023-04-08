package racingcar;

import java.util.List;

public class OutputView {

    public static void printPosition(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            for (int i = 0; i < racingCar.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
