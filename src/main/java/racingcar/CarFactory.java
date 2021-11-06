package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarFactory {
    int numberOfCars;

    CarFactory(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public List<Car> buildCars() {
        List<Car> carList = new ArrayList<>();
        IntStream.rangeClosed(1, numberOfCars)
                .forEach( number ->
                        carList.add(new Car(number))
                );

        return carList;
    }
}
