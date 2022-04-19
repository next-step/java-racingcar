package racingcar.domain;

import racingcar.dto.InputCar;
import racingcar.dto.InputRoundCount;

import java.util.List;

public class RacingGame {

    private Round round;
    private List<Car> cars;

    public RacingGame(InputCar inputCar, InputRoundCount inputRound) {
        if (isNull(inputCar, inputRound)) {
            throw new IllegalArgumentException();
        }
        cars = inputCar.toCars();
        round = inputRound.toRound();
    }

    private boolean isNull(InputCar carCount, InputRoundCount roundCount) {
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
        cars.forEach(car -> car.move());
    }
}
