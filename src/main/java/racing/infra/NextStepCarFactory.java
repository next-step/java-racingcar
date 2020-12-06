package racing.infra;

import racing.domain.Car;
import racing.domain.CarFactory;
import racing.domain.Cars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NextStepCarFactory implements CarFactory {

    private static final String DELIMITER = ",";

    @Override
    public Cars create(final String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(Car::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::of));
    }
}
