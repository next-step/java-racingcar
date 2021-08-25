package carracing.domain;

import static carracing.utils.RandomValueGenerator.generateRandom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        checkDuplicatedCarsName(cars);

        this.cars = cars;
    }

    public void checkDuplicatedCarsName(List<Car> cars) {
        Set<Car> carsSet = new HashSet<>(cars);
        if (carsSet.size() != cars.size()) {
            throw new IllegalArgumentException("차의 이름은 중복될 수 없습니다.");
        }
    }

    public List<Car> cars() {
        return cars;
    }

    public void moveCars() {
        cars.stream()
            .forEach(car -> car.move(generateRandom()));
    }

    public List<Car> findWinner() {
        Position maxPosition = findMaxPosition(cars);

        return cars.stream()
            .filter(car -> car.position().equals(maxPosition))
            .collect(Collectors.toList());
    }

    private Position findMaxPosition(List<Car> cars) {
        return cars.stream()
            .map(car -> car.position())
            .reduce(Position::calBiggerPosition)
            .get();
    }

}
