package study.step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] carNames) {
        return new Cars(
                Arrays.stream(carNames)
                        .map(Car::of)
                        .collect(Collectors.toList()));
    }

    public Cars move(MoveBehavior moveBehavior) {
        cars.stream()
                .filter(bahavior -> moveBehavior.isMoved())
                .forEach(car -> car.move());
        return this;
    }

    public int getSize() {
        return cars.size();
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
