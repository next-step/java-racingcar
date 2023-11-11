package racingcar;

import racingcar.movablestrategy.RandomRacingStrategy;

public class Racing {
    public static final int MINIMUM_CAR_COUNT = 2;
    public static final int MINIMUM_ROUND_COUNT = 1;
    private int roundCount;
    private Cars cars;

    public Racing(int inputCarCount, int inputRoundCount) {
        this.roundCount = inputRoundCount;

        cars = new Cars(inputCarCount, new RandomRacingStrategy());
    }

    public Racing(String racerNames, int inputRoundCount) {
        this.roundCount = inputRoundCount;

        cars = new Cars(racerNames, new RandomRacingStrategy());
    }

    public boolean holdPossible() {
        return cars.carsReady(MINIMUM_CAR_COUNT) && roundCount >= MINIMUM_ROUND_COUNT;
    }

    public void processRound() {
        cars.race();
    }

    public Cars racingInfo() {
        return cars;
    }
}
