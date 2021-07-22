package step3.model;

import step3.move.BasicMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(int carCount) {
        return new Cars(
            Stream.generate(() -> new Car(new BasicMoveStrategy()))
                .limit(carCount)
                .collect(Collectors.toList())
        );
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public int countOfCars() {
        return cars.size();
    }

    public List<Integer> getPointOfCarsByTime(int time) {
        return cars.stream()
            .map(car -> car.getPointOfTime(time))
            .collect(Collectors.toList());
    }
}
