package study.step5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private static final int MOVE_FORWARD_ONE_LOCATION = 1;
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] carNames) {
        return new Cars(
                Arrays.stream(carNames)
                        .map(Car::of)
                        .collect(Collectors.toList()));
    }

    public static Cars of(final List<Car> cars) {
        return new Cars(cars);
    }

    public int getSize() {
        return cars.size();
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public void move(MoveBehavior moveBehavior) {
        for (Car car : cars) {
            delegateMove(moveBehavior, car);
        }
    }

    private void delegateMove(MoveBehavior moveBehavior, Car car) {
        if (moveBehavior.isMoved()) {
            car.move(MOVE_FORWARD_ONE_LOCATION);
        }
    }

    public List<Car> getWinners() {
        int maxLocation = cars.stream()
                .map(car -> car.getLocation())
                .max(Integer::compare)
                .get();

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .collect(Collectors.toList());
    }
}
