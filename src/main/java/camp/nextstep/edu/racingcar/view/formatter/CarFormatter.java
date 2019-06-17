package camp.nextstep.edu.racingcar.view.formatter;

import camp.nextstep.edu.racingcar.domain.Car;
import camp.nextstep.edu.racingcar.domain.CarName;
import camp.nextstep.edu.racingcar.domain.Position;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFormatter implements Formatter<Car> {
    private static final String DELIMITER = " : ";
    private static final String DISPLAY_CHARACTER = "-";

    @Override
    public String format(Car car) {
        final CarName carName = car.getName();
        final String name = carName.value();

        final Position carPosition = car.getPosition();
        final int position = carPosition.value();

        final String formattedPosition = IntStream.range(0, position)
                .mapToObj(number -> DISPLAY_CHARACTER)
                .collect(Collectors.joining());
        return name + DELIMITER + formattedPosition;
    }
}
