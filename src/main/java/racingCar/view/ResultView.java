package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;

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
