package racingcar;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public static Cars setUp() {
        String carNames = InputView.readCarNames();

        return new Cars(
            Parser.parseCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    public static void main(String[] args) {
        Cars cars = setUp();
        int turn = InputView.getTurn();

        OutputView.printTurnResult();
        for (int index = 0; index < turn; index++) {
            cars.moveAll(new RandomMovableStrategy());
            OutputView.printDistance(cars);
        }
        System.out.println();

        OutputView.printWhoIsWinner(cars);
    }
}
