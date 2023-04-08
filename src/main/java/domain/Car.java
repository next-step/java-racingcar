package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private int id;
    private Move move;

    public Move getMove() {
        return move;
    }

    public Car(int id) {
        this.id = id;
        move = new Move();
    }

    public static List<Car> createCarList(int numberOfCars) {
        return IntStream
                .range(0, numberOfCars)
                .mapToObj(Car::new)
                .collect(Collectors
                        .toList());
    }

    public void attemptMove() {
        move.attemptMove();
    }

    public String getCurrentDistance() {
        return move.getCarCurrentDistance();
    }
}
