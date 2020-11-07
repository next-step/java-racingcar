package step04;

import step03.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Cars {
    public final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String carNames, int position, MoveStrategy moveStrategy) {
        final String delimiter = ",";
        return Arrays.stream(carNames.split(delimiter))
                     .map(name -> Car.of(name, position, moveStrategy))
                     .collect(collectingAndThen(toList(), Cars::new));
    }

    public void move() {
        cars.forEach(car -> car.move());
    }

}
