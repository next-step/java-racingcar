package racingcar.ui;

import java.util.List;

import racingcar.RacingCar;
import utils.RandomUtils;

public class RacingCarResultView {

    public static void view(List<RacingCar> racingCars) {
        RacingCarResultView.display(racingCars);
        System.out.println();
    }

    public static void display(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            System.out.println(car.display());
        }
    }

}
