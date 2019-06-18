package step2.view;

import step2.domain.Car;
import step2.domain.Cars;

import java.util.List;

public class OutputView {
    private static final String POSITION_OF_CAR = "-";

    public OutputView(Cars cars) {
        for (Car car : cars.getCars()) {
            printCars(car);
        }
        System.out.println();
    }

    private void printCars(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_OF_CAR);
        }
        System.out.println();
    }

}
