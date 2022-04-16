package racingcar;

import racingcar.domain.*;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Cars cars = createCars();
        RacingCarGame game = createGame(cars);
        startGame(game, cars);
        finishGame(cars);
    }

    private static Cars createCars() {
        List<Car> cars = InputView.promptNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static RacingCarGame createGame(Cars cars) {
        return new RacingCarGame(cars, InputView.promptRounds(), new RandomMoveStrategy());
    }

    private static void startGame(RacingCarGame game, Cars cars) {
        OutputView.printRaceStart();
        while (!game.isFinished()) {
            game.moveCars();
            OutputView.printCurrentPositions(cars);
        }
    }

    private static void finishGame(Cars cars) {
        List<Car> mostDistantCars = cars.getMostDistantCars();
        OutputView.printWinners(mostDistantCars);
    }
}
