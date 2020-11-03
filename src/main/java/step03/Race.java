package step03;

import step03.strategy.MoveStrategy;
import step03.view.ResultView;

import java.util.stream.Stream;

public class Race {
    private final int numberOfMoves;
    private final Cars cars;

    private Race(int numberOfMoves, Cars cars) {
        this.numberOfMoves = numberOfMoves;
        this.cars = cars;
    }

    public static Race of(int numberOfMoves, Cars cars) {
        validateNumberOfMoves(numberOfMoves);
        return new Race(numberOfMoves, cars);
    }

    private static void validateNumberOfMoves(int numberOfMoves) {
        Validator.validatePositiveNumber(numberOfMoves);
    }

    public void operate(MoveStrategy moveStrategy, String carKind) {
        ResultView.print(cars.stream(), carKind);

        Stream.iterate(1, a -> a + 1)
                .limit(numberOfMoves)
                .forEach(moveCount -> {
                    cars.move(moveStrategy);
                    ResultView.print(cars.stream(), carKind);
                });
    }

}
