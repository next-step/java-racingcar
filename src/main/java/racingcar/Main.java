package racingcar;

import racingcar.domain.*;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class Main {

    private static Cars cars;
    private static RacingCarGame game;

    public static void main(String[] args) {
        initGame();
        startGame();
        finishGame();
    }

    private static void initGame() {
        cars = new Cars(InputView.promptNames());
        game = new RacingCarGame(cars, InputView.promptRounds(), new RandomMoveStrategy());
    }

    private static void startGame() {
        OutputView.printRaceStart();
        while (!game.isFinished()) {
            game.moveCars();
            OutputView.printCurrentPositions(cars);
        }
    }

    private static void finishGame() {
        List<Car> mostDistantCars = cars.getMostDistantCars();
        OutputView.printWinners(mostDistantCars);
    }
}
