package racingcar.domain;

import racingcar.pattern.NumberGenerator;

import java.util.Map;

public class RacingCar  {
    private Cars cars;
    private Round round;
    private final NumberGenerator numberGenerator;

    public RacingCar(Cars cars, Round round, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.round = round;
        this.numberGenerator = numberGenerator;
    }

    public void playRound() {
        round = round.decreaseRound();
        cars.play(numberGenerator);
    }

    public Winners findWinners() {
        return cars.getWinners();
    }

    public Map<String, Integer> getDistance() {
        return cars.getPositions();
    }
}
