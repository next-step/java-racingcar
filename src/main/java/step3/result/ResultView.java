package step3.result;

import step3.racingcar.RacingCar;

import java.util.List;

public class ResultView {
    public static void printTryResult(final List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println("-".repeat(car.currentDistance()));
        }
        
        System.out.println();
    }
}
