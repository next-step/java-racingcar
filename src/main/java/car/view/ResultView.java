package car.view;

import car.RacingCar;

import java.util.List;

public class ResultView {

    public static void printStatus(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(
                    new String(new char[racingCar.getMoveCount()])
                            .replace("\0", "-")
            );
        }
        System.out.println();
    }
}
