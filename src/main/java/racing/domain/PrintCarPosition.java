package racing.domain;

import racing.Car;

import static racing.TheGame.cars;

public class PrintCarPosition {
    static void printCarPosition() {
        for (Car car : cars) {
            System.out.println(car.getPositionFormat());
        }
    }

}
