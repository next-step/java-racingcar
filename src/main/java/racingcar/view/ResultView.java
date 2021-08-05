package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;

public class ResultView {
    void printCurrentState(ArrayList<Car> cars) {
        for (Car car : cars) {
            printLocationOfCar(car);
        }
    }

    void printLocationOfCar(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
