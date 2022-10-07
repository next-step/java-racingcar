package step5.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final Set<Car> cars;

    public Cars(String[] carNames) {
        Set<Car> carSet = new HashSet<>(carNames.length);

        for (String name : carNames) {
            Car car = new Car(name);
            carSet.add(car);
        }

        this.cars = carSet;
    }

    public Set<CarDto> getWinningCarNames() {
        int maxPosition = this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);

        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(CarDto::new)
                .collect(Collectors.toSet());
    }

    public Set<Car> moveCars() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.createRandomNumber());
        }
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
