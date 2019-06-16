package camp.nextstep.edu.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cars {

    private static final int MINIMUM_NUMBER_OF_CARS = 0;

    private final List<Car> carList;

    private Cars(List<Car> carList) {
        assert carList != null;
        this.carList = new ArrayList<>(carList);
    }

    public static Cars defaultInstance(int numberOfCars) {
        if (numberOfCars < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("'numberOfCars' must be greater than or equal to " + MINIMUM_NUMBER_OF_CARS +
                    ". numberOfCars:" + numberOfCars);
        }
        final List<Car> carList = IntStream.range(0, numberOfCars)
                .mapToObj(number -> Car.defaultInstance())
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public Stream<Car> stream() {
        return carList.stream();
    }

    public int size() {
        return carList.size();
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
