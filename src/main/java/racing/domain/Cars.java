package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String NAME_SEPARATOR = ",";

    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars run(RandomNumberGenerator randomNumGenerator) {
        for(Car car: cars) {
            car.move(randomNumGenerator.getRandomNum());
        }
        return this;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars generateCarsWithName(String names) {
        String[] carNames = names.split(NAME_SEPARATOR);
        for(String name: carNames) {
            cars.add(new Car(name));
        }
        return this;
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .max(Comparator.comparing(Car::getMoveCount))
                .map(Car::getMoveCount)
                .get();
    }

    private Cars findCarByMoveCount(int maxMoveCount) {
        List<Car> results = cars.stream()
                .filter(it -> it.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
        return new Cars(results);
    }

    public Cars findWinner() {
        int maxMoveCount = getMaxMoveCount();
        return findCarByMoveCount(maxMoveCount);
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
        return cars != null ? cars.hashCode() : 0;
    }

    public String getNames() {
        return cars.stream()
                .map(it -> it.getName().toString()).collect(Collectors.joining(NAME_SEPARATOR));
    }
}
