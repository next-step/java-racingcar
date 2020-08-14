package pobiRacingCar.view;

import pobiRacingCar.domain.Car;
import pobiRacingCar.domain.Cars;

public class InputView {
    Cars cars = new Cars();
    Car car = new Car("");
    public static String getCarNames() {

        return car.getCarNames();
    }

    public static int getTryNo() {
        return tryno;
    }
}
