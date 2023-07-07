package car.view;

import car.domain.Car;
import car.domain.CarFormatter;

public class DefaultCarFormatter implements CarFormatter {

    private static final String NAME_VALUE_JOIN_DELIMITER = " : ";
    private static final String DISTANCE_MARKER = "-";

    @Override
    public String format(final Car car) {
        return car.getName() + NAME_VALUE_JOIN_DELIMITER + DISTANCE_MARKER.repeat(
            car.getPosition());
    }
}
