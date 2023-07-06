package car.ui;

import car.domain.Car;

public class DefaultCarFormatter implements CarFormatter {

    @Override
    public String format(final Car car) {
        return car.getNameValue() + " : " + "-".repeat(car.getPosition());
    }
}
