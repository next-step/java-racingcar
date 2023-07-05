package car.ui;

import car.domain.Car;

public class DefaultCarFormatter implements CarFormatter {

    public String format(Car car) {
        return car.getNameValue() + " : " + "-".repeat(car.getPosition());
    }
}
