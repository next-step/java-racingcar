package racingcar.domain;

import racingcar.movablestrategy.MovableStrategy;

import java.util.List;

public class Racing {
    public static final int MINIMUM_CAR_COUNT = 2;
    public static final int MINIMUM_ROUND_COUNT = 1;
    private int roundCount;
    private Cars cars;

    public Racing(int inputCarCount, int inputRoundCount) {
        this.roundCount = inputRoundCount;

        cars = new Cars(inputCarCount);
    }

    public Racing(String racerNames, int inputRoundCount) {
        this.roundCount = inputRoundCount;

        cars = new Cars(racerNames);
    }

    public boolean holdPossible() {
        return cars.carsReady(MINIMUM_CAR_COUNT) && roundCount >= MINIMUM_ROUND_COUNT;
    }

    public List<CarStatDTO> processRound(MovableStrategy movableStrategy) {
        return cars.race(movableStrategy);
    }

    public Cars racingInfo() {
        return cars;
    }
}
