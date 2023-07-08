package car.domain.model;

import car.utils.RandomNumberGenerator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private static final String REGEX_CAR_NAME = ",";
    private final List<Car> cars;

    public Cars(final String inputCarNames) {
        cars = Arrays.stream(inputCarNames.split(REGEX_CAR_NAME))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void raceOnce() {
        cars.forEach(car -> car.move(RandomNumberGenerator.getRandomNumber()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
