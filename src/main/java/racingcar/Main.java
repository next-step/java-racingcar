package racingcar;

import racingcar.domain.*;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class Main {

    private static int rounds;
    private static RacingCarGame game;
    private static Cars cars;

    public static void main(String[] args) {
        initGame();
        startGame();
        finishGame();
    }

    private static void initGame() {
        cars = new Cars(InputView.promptNames());
        rounds = InputView.promptRounds();
        game = new RacingCarGame(cars, rounds, new RandomMoveStrategy());
    }

    private static void startGame() {
        OutputView.printRaceStart();
        for (int i = 0; i < rounds; i++) {
            game.proceedRound();
            OutputView.printCurrentPositions(cars);
        }
    }

    private static void finishGame() {
        List<Car> mostDistantCars = cars.getMostDistantCars();
        OutputView.printWinners(mostDistantCars);
    }
}
