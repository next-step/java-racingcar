package racingcar.vo;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class CarResult {

    private static final String CAR_RESULT_FORMAT = "[{0}] {1}";
    private static final String POSITION_ICON = "-";

    private final int number;
    private final int position;

    private CarResult(final int number, final int position) {
        this.number = number;
        this.position = position;
    }

    @Override
    public String toString() {
        final String positionIcons = POSITION_ICON.repeat(this.position);

        return format(CAR_RESULT_FORMAT, this.number, positionIcons);
    }

    public static List<CarResult> fromCars(final List<Car> cars) {
        return cars.stream()
                .map(car -> new CarResult(car.number(), car.position()))
                .collect(Collectors.toList());
    }
}