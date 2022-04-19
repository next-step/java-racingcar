package racingcar.app;

import calculator.StringSplitterFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.car.strategy.CarActionStrategy;
import racingcar.domain.car.strategy.RandomMoveStrategy;
import racingcar.domain.round.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    public void start() {
        Cars cars = generateCars(new RandomMoveStrategy());
        Rounds rounds = generateRounds(cars);

        OutputView.printGameResult(rounds.play());
    }

    private Cars generateCars(CarActionStrategy carActionStrategy) {
        return new Cars(getNames(), carActionStrategy);
    }

    private List<String> getNames() {
        return StringSplitterFactory.resolve(InputView.inputCarNames()).split();
    }

    private Rounds generateRounds(Cars cars) {
        return new Rounds(cars, InputView.inputRounds());
    }
}
