package study.step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> car) {
        this.cars = car;
    }

    public static Cars of(int carNumber) {
        return new Cars(Arrays.stream(new int[carNumber])
                .mapToObj(car -> Car.of())
                .collect(Collectors.toList())
        );
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
