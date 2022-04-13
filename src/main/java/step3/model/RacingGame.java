package step3.model;

import java.util.List;

public class RacingGame {

    private final int tryCount;
    private final Cars cars;

    public RacingGame(RacingConfig racingConfig) {
        this.tryCount = racingConfig.getTryCount().getCount();
        this.cars = new Cars(racingConfig.getCarCount(), racingConfig.getTryStrategy());
    }

    public void race() {
        for (int i = 0; i < tryCount; i++) {
            cars.tryOnceEach();
        }
    }

    public List<Integer> getResult() {
        return cars.getSuccessCountEach();
    }
}
