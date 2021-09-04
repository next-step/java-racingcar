package step6.view;

import step6.domain.Car;
import step6.domain.Cars;

public class ResultView {
    public static void printCurrentPosition(Cars cars) {
        for (Car car: cars.getCars()) {
            System.out.print(car.getCarName() + ": " + car.getPosition());
            System.out.println();
        }
    }
}
