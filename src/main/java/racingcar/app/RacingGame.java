package racingcar.app;

import racingcar.domain.car.Cars;
import racingcar.domain.round.Rounds;
import racingcar.dto.RoundResults;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        Cars cars = generateCars();
        Rounds rounds = generateRounds(cars);

        RoundResults roundResults = rounds.play();

        OutputView.printGameResult(roundResults);
    }

    private Cars generateCars() {
        return new Cars(InputView.inputCarCounts());
    }

    private Rounds generateRounds(Cars cars) {
        return new Rounds(cars, InputView.inputRounds());
    }
}
