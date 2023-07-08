package car.domain.model;

import car.utils.RandomNumberGenerator;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    public Cars(final String inputCarNames) {
        CarNames carNames = new CarNames(inputCarNames);
        cars = carNames.getCarNames().stream()
            .map(CarName::getMyCarName)
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
