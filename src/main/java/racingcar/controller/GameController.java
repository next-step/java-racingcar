package racingcar.controller;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final Cars cars;
    private final int turn;

    public GameController() {
        this.cars = setUpCars();
        this.turn = InputView.getTurn();
    }

    private Cars setUpCars() {
        String carNames = InputView.readCarNames();

        return new Cars(
            Parser.parseCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    public void play() {
        OutputView.printTurnResult();
        for (int index = 0; index < turn; index++) {
            cars.moveAll(RandomMovableStrategy.getInstance());
            OutputView.printDistance(cars);
        }
        System.out.println();
        OutputView.printWhoIsWinner(cars);
    }

}
