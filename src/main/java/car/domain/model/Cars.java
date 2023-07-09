package car.domain.model;

import car.utils.RandomNumberGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private static final String REGEX_CAR_NAME = ",";
    private final List<Car> cars;

    public Cars(final String inputCarNames) {
        cars = Arrays.stream(inputCarNames.split(REGEX_CAR_NAME))
            .map(Car::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public void raceOnce() {
        cars.forEach(car -> car.move(RandomNumberGenerator.getRandomNumber()));
    }

    public List<Car> getWinnerCars() {
        return cars.stream()
            .filter(car -> car.isWinner(getWinnerPosition()))
            .collect(Collectors.toUnmodifiableList());
    }

    private int getWinnerPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max().getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }

}
