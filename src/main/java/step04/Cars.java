package step04;

import step03.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Cars implements Cloneable {
    public final List<Car> cars;
    static final String delimiter = ",";

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(String carNames, int position, MoveStrategy moveStrategy) {
        return Arrays.stream(carNames.split(delimiter))
                .map(name -> Car.of(name, position, moveStrategy))
                .collect(collectingAndThen(toList(), Cars::new));
    }

    public void move() {
        cars.forEach(car -> car.move());
    }

    public List<Car> clonedCars() {
        List<Car> clonedCars = cars.stream().map(car -> {
            try {
                return car.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return car;
        }).collect(toList());

        return clonedCars;
    }

}
