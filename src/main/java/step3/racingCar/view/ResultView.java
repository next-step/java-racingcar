package step3.racingCar.view;

import step3.racingCar.domain.Car;
import step3.racingCar.domain.Cars;

public class ResultView {

    public static void output() {
        System.out.println("실행결과");
    }
    public static void result(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
