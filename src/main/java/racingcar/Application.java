package racingcar;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.InputView;
import racingcar.utils.OutputView;

public class Application {

    private static final int RANDOM_BOUND = 10;

    public static Cars setUp() {
        String carNames = InputView.readCarNames();
        return new Cars(
            InputView.parseCarNames(carNames).stream()
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
            game.play(new RandomMovableStrategy(RANDOM_BOUND));
        }

        OutputView.printWhoIsWinner(game.winners());
    }
}
