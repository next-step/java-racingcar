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

    public GameController(String carNames, int turn) {
        this.cars = setUpCars(carNames);
        this.turn = turn;
    }

    private Cars setUpCars(String carNames) {
        return new Cars(
            Parser.parseCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    public void play(MovableStrategy strategy) {
        OutputView.printTurnResult();
        for (int index = 0; index < turn; index++) {
            cars.moveAll(strategy);
            OutputView.printDistance(cars);
        }
        System.out.println();
        OutputView.printWhoIsWinner(cars);
    }

}
