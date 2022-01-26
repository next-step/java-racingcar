package racingcar.controller;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.MovableStrategy;
import racingcar.utils.Parser;
import racingcar.view.OutputView;

public class GameController {

    private final Cars cars;
    private final int turn;

    public GameController(final String carNames, final int turn) {
        this.cars = setUpCars(carNames);
        this.turn = turn;
    }

    private Cars setUpCars(final String carNames) {
        return new Cars(
            Parser.parseCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    private void iterateCarMoves(final MovableStrategy strategy) {
        for (int index = 0; index < turn; index++) {
            cars.moveAll(strategy);
            OutputView.printDistance(cars);
        }
    }

    public void play(final MovableStrategy strategy) {
        OutputView.printTurnResult();

        iterateCarMoves(strategy);

        OutputView.printWhoIsWinner(cars);
        System.out.println();
    }

}
