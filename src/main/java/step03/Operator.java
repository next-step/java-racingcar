package step03;

import step03.strategy.MoveStrategy;

import java.util.stream.Stream;

public class Operator {
    private final int numberOfMoves;
    private final Cars cars;

    private Operator(int numberOfCars, Cars cars) {
        this.numberOfMoves = numberOfCars;
        this.cars = cars;
    }

    public static Operator of(int numberOfCars, Cars cars) {
        return new Operator(numberOfCars, cars);
    }

    public static Operator of(int numberOfCars, int numberOfMoves) {
        return of(
            numberOfMoves,
            Cars.of(numberOfCars)
        );
    }

    public void operate(MoveStrategy moveStrategy) {
        cars.show();

        Stream.iterate(1, a -> a + 1)
                .limit(numberOfMoves)
                .forEach(moveCount -> {
                    cars.move(moveStrategy);
                    cars.show();
                });
    }

}
