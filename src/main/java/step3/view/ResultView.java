package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

public class ResultView {

    public static void print(Cars cars) {
        for (Car car : cars.cars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }
}
