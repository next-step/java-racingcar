package step03;

import step03.strategy.RandomMoveStrategy;
import step03.view.InputView;

public class Main {
    public static void main(String[] args) {
        final String carKind = "-";

        int numberOfCars = InputView.readInteger(Constant.NUMBER_OF_CARS_QUESTION);
        Validator.validatePositiveNumber(numberOfCars);

        int numberOfMoves = InputView.readInteger(Constant.NUMBER_OF_MOVES_QUESTION);
        Validator.validatePositiveNumber(numberOfMoves);

        Cars cars = Cars.of(numberOfCars);
        Race race = Race.of(numberOfMoves, cars);
        race.operate(RandomMoveStrategy.of(), carKind);

    }
}
