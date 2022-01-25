package racingcar;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

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
        Game game = new Game(cars);
        int turn = InputView.getTurn();

        OutputView.printTurnResult();
        for (int index = 0; index < turn; index++) {
            game.play(new RandomMovableStrategy());
        }

        OutputView.printWhoIsWinner(cars);
    }
}
