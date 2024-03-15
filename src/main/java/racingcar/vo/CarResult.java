package racingcar.vo;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.RacingCars;

public class CarResult {

    private static final String CAR_RESULT_FORMAT = "{0} {1}";
    private static final String POSITION_ICON = "-";

    private final String name;
    private final int position;

    private CarResult(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        final String positionIcons = POSITION_ICON.repeat(this.position);

        return format(CAR_RESULT_FORMAT, this.name, positionIcons);
    }

    public static List<CarResult> fromCars(final RacingCars cars) {
        return cars.cars()
                .stream()
                .map(car -> new CarResult(car.name(), car.position()))
                .collect(Collectors.toList());
    }
}
