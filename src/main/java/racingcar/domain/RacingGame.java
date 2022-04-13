package racingcar.domain;

import racingcar.domain.input.InputCarCount;
import racingcar.domain.input.InputRoundCount;
import racingcar.util.ConditionGenerator;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

    private Round round;
    private List<Car> cars;

    public RacingGame(InputCarCount inputCar, InputRoundCount inputRound) {
        if (isNull(inputCar, inputRound)) {
            throw new IllegalArgumentException();
        }
        cars = inputCar.toCars();
        round = inputRound.toRound();
    }

    private boolean isNull(InputCarCount carCount, InputRoundCount roundCount) {
        return carCount == null || roundCount == null;
    }

    public void play() {
        while (round.isOngoing()) {
            roundProceed();
            ResultView.renderResultView(cars, round.getCurrentRound());
            round.nextRound();
        }
    }

    private void roundProceed() {
        cars.forEach(car -> car.stopOrGo(ConditionGenerator.getInstance().generateRandomCondition()));
    }
}
