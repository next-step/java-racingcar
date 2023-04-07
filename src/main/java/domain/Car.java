package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private int id;
    private int move;

    public Car(int id) {
        this.id = id;
        move = 0;
    }

    public static List<Car> createCarList(int numberOfCars) {
        return IntStream
                .range(0, numberOfCars)
                .mapToObj(Car::new)
                .collect(Collectors
                        .toList());
    }

}
