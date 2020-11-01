package step03;

import step03.strategy.MoveStrategy;

import java.util.stream.Stream;

public class Operator {
    private final int numberOfMoves;
    private final Cars cars;

    private Operator(int numberOfMoves, Cars cars) {
        this.numberOfMoves = numberOfMoves;
        this.cars = cars;
    }

    public static Operator of(int numberOfMoves, Cars cars) {
        return new Operator(numberOfMoves, cars);
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
