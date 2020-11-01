package step03;

import step03.strategy.RandomMoveStrategy;
import step03.view.InputView;

public class Main {
    public static void main(String[] args) {
        final String carKind = "-";

        int numberOfCars = InputView.scanNumberOfCars();
        Validator.validatePositiveNumber(numberOfCars);

        int numberOfMoves = InputView.scanNumberOfMoves();
        Validator.validatePositiveNumber(numberOfMoves);

        Cars cars = Cars.of(numberOfCars);
        Operator operator = Operator.of(numberOfMoves, cars);
        operator.operate(RandomMoveStrategy.of(), carKind);

    }
}
