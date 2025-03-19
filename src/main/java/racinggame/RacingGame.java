package racinggame;

import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();

        Cars cars = Cars.from(carNames, new RandomMoveStrategy());

        OutputView.printRace(cars, rounds);
        OutputView.printWinners(cars.getWinners());
    }
}
