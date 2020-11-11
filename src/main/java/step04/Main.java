package step04;

import step03.strategy.RandomMoveStrategy;

public class Main {
    public static void main(String[] args) {
        final String[] carNames = InputView.readCarNames();

        final int numberOfMoves = InputView.readNumberOfMoves();

        final int position = 1;
        Cars cars = Cars.of(carNames, position, RandomMoveStrategy.of());

        Race race = Race.of(numberOfMoves, cars);

        final String carKind = "-";
        ResultView resultView = ResultView.of(carKind);

        race.run(resultView);
    }
}
