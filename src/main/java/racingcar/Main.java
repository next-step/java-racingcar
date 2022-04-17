package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cars cars = createCars();
        RacingCarGame game = createGame(cars);
        startGame(game, cars);
        finishGame(cars);
    }

    private static Cars createCars() {
        List<String> names = InputView.promptNames();
        List<Car> cars = Car.createCars(names);
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
