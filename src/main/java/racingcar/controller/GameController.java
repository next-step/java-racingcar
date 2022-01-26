package racingcar.controller;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private GameController() {}

    public static Cars setUp() {
        String carNames = InputView.readCarNames();

        return new Cars(
            Parser.parseCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    private static void play(Cars cars, int turn) {
        for (int index = 0; index < turn; index++) {
            cars.moveAll(RandomMovableStrategy.getInstance());
            OutputView.printDistance(cars);
        }
    }

    public static void startGame() {
        Cars cars = setUp();
        int turn = InputView.getTurn();

        OutputView.printTurnResult();
        play(cars, turn);

        OutputView.printWhoIsWinner(cars);
    }
}
