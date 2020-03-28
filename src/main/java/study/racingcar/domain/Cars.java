package study.racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars implements Iterable<Car> {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<String> carNames) {
        if (Objects.isNull(carNames)) {
            throw new IllegalArgumentException("null을 차로 입력할 수 없습니다.");
        }

        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public void add(Car... cars) {
        this.cars.addAll(Arrays.asList(cars));
    }

    public int size() {
        return cars.size();
    }

    public int getMaxPosition() {
        return Collections
                .max(cars, Comparator.comparing(Car::getPosition))
                .getPosition();
    }

    public Cars getByPosition(int position) {
        List<Car> matchedCars = cars.stream()
                .filter(car -> car.isPositionEqualTo(position))
                .map(Car::clone)
                .collect(Collectors.toList());

        Cars newCars = new Cars();
        newCars.cars = matchedCars;

        return newCars;
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public Cars clone() {
        Cars clonedCars = new Cars();
        for (Car car : this) {
            clonedCars.add(car.clone());
        }

        return clonedCars;
    }

    @Override public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
