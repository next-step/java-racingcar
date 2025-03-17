package racingcar.ui;

import java.util.List;

import racingcar.RacingCar;

public class RacingCarResultView {

    public static void view(List<RacingCar> racingCars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            RacingCarResultView.moveIfMovable(racingCars);
            RacingCarResultView.display(racingCars);
            System.out.println();
        }
    }

    public static void moveIfMovable(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            car.moveIfMovable();
        }
    }

    public static void display(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            System.out.println(car.display());
        }
    }

}
