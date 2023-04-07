package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private int id;
    private Move move;

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

    void attemptMove(int attemptCount) {
        move.attemptMove(attemptCount);
    }

    public int getMoveCount() {
        return move.getMove();
    }
}
