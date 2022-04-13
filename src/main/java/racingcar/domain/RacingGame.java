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

    public Histories play() {
        Histories histories = new Histories();
        while (round.isOngoing()) {
            roundProceed();
            histories.add(new History(round, cars));
            round.nextRound();
        }
        return histories;
    }

    private void roundProceed() {
        cars.forEach(car -> car.stopOrGo(ConditionGenerator.getInstance().generateRandomCondition()));
    }
}
