package study.carracing.ui;

import study.carracing.domain.Car;
import study.carracing.domain.RacingCars;

public class ResultView {

    public static void outputResult(RacingCars cars) {
        System.out.println("실행 결과");
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
    }
}
