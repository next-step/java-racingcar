package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomMoveStrategy;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCar racingCar = RacingCar.from(Cars.create(InputView.readCarCount()), InputView.readAttemptCount());
        OutputView.printResultMessage();
        OutputView.printRaceResult(racingCar.race(new RandomMoveStrategy(new RandomGenerator())));
    }
}
