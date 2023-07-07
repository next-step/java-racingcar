package car.view;

import car.domain.Car;
import car.domain.CarsFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultCarsFormatter implements CarsFormatter {

    private static final String NAME_VALUE_JOIN_DELIMITER = " : ";
    private static final String DISTANCE_MARKER = "-";
    private static final String CARS_JOIN_DELIMITER = "\n";
    private static final String FORMAT_END = "\n";

    @Override
    public String format(final List<Car> cars) {
        final String formattedCars = cars.stream()
            .map(this::formatSingleCar)
            .collect(Collectors.joining(CARS_JOIN_DELIMITER));

        return formattedCars + FORMAT_END;
    }

    public String formatSingleCar(final Car car) {
        return car.getName() + NAME_VALUE_JOIN_DELIMITER + DISTANCE_MARKER.repeat(
            car.getPosition());
    }
}
