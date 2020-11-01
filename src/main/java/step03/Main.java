package step03;

import step03.strategy.RandomMoveStrategy;
import step03.view.InputView;

public class Main {
    public static void main(String[] args) {
        int numberOfCars = InputView.scanNumberOfCars();
        Validator.validatePositiveNumber(numberOfCars);

        int numberOfMoves = InputView.scanNumberOfMoves();
        Validator.validatePositiveNumber(numberOfMoves);

        Operator operator = Operator.of(numberOfCars, numberOfMoves);
        operator.operate(RandomMoveStrategy.of());

    }
}
