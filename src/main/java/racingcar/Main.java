package racingcar;

import racingcar.domain.*;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static Cars cars;
    private static RacingCarGame game;

    public static void main(String[] args) {
        initGame();
        startGame();
        finishGame();
    }

    private static void initGame() {
        List<String> names = InputView.promptNames();
        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        cars = new Cars(carList);
        game = new RacingCarGame(Main.cars, InputView.promptRounds(), new RandomMoveStrategy());
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
