package ui;

import racing.Car;
import racing.RacingCars;

import java.util.List;

public class ResultView {

    public static void showRaceResult(RacingCars racingCars, int tryCount) {
        if (tryCount == 0) {
            System.out.println();
            System.out.println("실행 결과");
        }

        List<Car> racedCarList = racingCars.getCarList();

        for (int i = 0; i < racedCarList.size(); i++) {
            showCarLocation(racedCarList.get(i));
            System.out.println();
        }
        System.out.println();
    }

    private static void showCarLocation(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }
}
