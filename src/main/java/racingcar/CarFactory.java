package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarFactory {
    private final int numberOfCars;

    CarFactory(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public List<Car> buildCars() {
        List<Car> cars = new ArrayList<>();
        IntStream.rangeClosed(1, numberOfCars)
                .forEach( number ->
                        cars.add(new Car(number))
                );

        return cars;
    }
}
