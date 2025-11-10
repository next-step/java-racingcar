package carRacing;

import java.util.List;

public class ResultView {

    public static void printResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printPosition(racingCar);
        }
        System.out.println();
    }

    private static void printPosition(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
