package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarFactory {
    private final int STARTING_NUMBER_OF_CAR = 1;

    private final int numberOfCars;

    CarFactory(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public List<Car> buildCars() {
        List<Car> cars = new ArrayList<>();
        IntStream.rangeClosed(STARTING_NUMBER_OF_CAR, numberOfCars)
                .forEach( number ->
                        cars.add(new Car(number))
                );

        return cars;
    }
}
