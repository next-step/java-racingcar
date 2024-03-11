package view;

import java.util.List;
import racingCar.RacingCar;

public class ResultView {

    public static void printResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.toResult());
        }
        System.out.println();
    }
}
