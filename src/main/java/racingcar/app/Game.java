package racingcar.app;

import racingcar.domain.Cars;
import racingcar.domain.Rounds;
import racingcar.dto.RoundResults;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        Cars cars = generateCars();
        Rounds rounds = generateRounds(cars);

        RoundResults roundResults = rounds.play();

        OutputView.printGameResult(roundResults);
    }

    private Cars generateCars() {
        int carCounts = InputView.inputCarCounts();
        return Cars.fromCarCounts(carCounts);
    }

    private Rounds generateRounds(Cars cars) {
        int roundCounts = InputView.inputRounds();
        return Rounds.fromCarsAndRoundsCounts(cars, roundCounts);
    }
}
