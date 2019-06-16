package camp.nextstep.edu.racingcar.view.formatter;

import camp.nextstep.edu.racingcar.domain.Car;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFormatter implements Formatter<Car> {
    private static final String DISPLAY_CHARACTER = "-";

    @Override
    public String format(Car car) {
        final int position = car.getPosition();
        return IntStream.range(0, position)
                .mapToObj(number -> DISPLAY_CHARACTER)
                .collect(Collectors.joining());
    }
}
