package refactoring.racingcar;

import refactoring.racingcar.domain.RacingGame;
import refactoring.racingcar.strategy.RandomMoveStrategy;
import refactoring.racingcar.view.InputView;
import refactoring.racingcar.view.OutputView;

import java.util.Random;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNamesString = InputView.getCarNamesString();
        int numberOfTries = InputView.getNumberOfTries();

        RacingGame racingGame = RacingGame.setUpGame(
            carNamesString,
            new RandomMoveStrategy(() -> new Random().nextInt(10), 4)
        );

        for (int i = 0; i < numberOfTries; i++) {
            racingGame.play();
            OutputView.printPositions(racingGame.getRacingCars());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
