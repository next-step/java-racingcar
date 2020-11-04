package step03;

import step03.strategy.RandomMoveStrategy;
import step03.view.InputView;
import step03.view.ResultView;

public class Main {
    public static void main(String[] args) {

        int numberOfCars = InputView.readInteger(Constant.NUMBER_OF_CARS_QUESTION);
        Cars cars = Cars.of(numberOfCars, 1, RandomMoveStrategy.of());

        int numberOfMoves = InputView.readInteger(Constant.NUMBER_OF_MOVES_QUESTION);
        Race race = Race.of(numberOfMoves, cars);

        final String dashCar = "-";
        ResultView dashCarView = ResultView.of(dashCar);

        race.operate(dashCarView);

    }
}
