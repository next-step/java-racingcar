package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars implements Iterable<Car> {

    private final List<Car> carList;

    private Cars(List<Car> carList) {
        assert carList != null;
        this.carList = new ArrayList<>(carList);
    }

    public static Cars defaultInstance(CarNames carNames) {
        AssertUtils.notNull(carNames, "'carNames' must not be null");
        final List<Car> carList = carNames.stream()
                .map(Car::from)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public Stream<Car> stream() {
        return carList.stream();
    }

    public Cars move(MovingStrategy movingStrategy) {
        final List<Car> movedCarList = carList.stream()
                .map(car -> {
                    final int distance = movingStrategy.getDistanceToMove();
                    return car.move(distance);
                })
                .collect(Collectors.toList());
        return new Cars(movedCarList);
    }

    @Override
    public Iterator<Car> iterator() {
        return carList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Car> action) {
        carList.forEach(action);
    }

    @Override
    public Spliterator<Car> spliterator() {
        return carList.spliterator();
    }

    @Override
    public String toString() {
        return "Cars{" +
                "carList=" + carList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return carList.equals(cars.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList);
    }
}
