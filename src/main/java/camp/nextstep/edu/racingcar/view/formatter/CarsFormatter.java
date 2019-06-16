package camp.nextstep.edu.racingcar.view.formatter;

import camp.nextstep.edu.racingcar.domain.Car;
import camp.nextstep.edu.racingcar.domain.Cars;

import java.util.stream.Collectors;

public class CarsFormatter implements Formatter<Cars> {
    private static final String DELIMITER_OF_CARS = "\n";

    private final Formatter<Car> carFormatter;

    public CarsFormatter(Formatter<Car> carFormatter) {
        this.carFormatter = carFormatter;
    }

    @Override
    public String format(Cars cars) {
        return cars.stream()
                .map(carFormatter::format)
                .collect(Collectors.joining(DELIMITER_OF_CARS));
    }
}
