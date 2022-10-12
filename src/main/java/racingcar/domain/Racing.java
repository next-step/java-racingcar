package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Racers;
import racingcar.domain.RacingRecord;
import racingcar.strategy.NumberGenerateStrategy;
import racingcar.strategy.RandomNumberGenerateStrategy;

public class Racing {

    private final NumberGenerateStrategy DEFAULT_STRATEGY = new RandomNumberGenerateStrategy();

    private Racers racers;
    private final List<RacingRecord> result = new ArrayList<>();
    private NumberGenerateStrategy strategy;

    private Racing() {
    }

    public Racing(final List<String> carNames) {
        this.racers = new Racers(carNames);
        this.strategy = DEFAULT_STRATEGY;
    }

    public Racing(final List<String> carNames, final NumberGenerateStrategy strategy) {
        this.racers = new Racers(carNames);
        this.strategy = strategy;
    }

    public void race(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            racers.moveAll(strategy);
            result.add(RacingRecord.from(racers));
        }
    }

    public List<Car> winners() {
        int maxPosition = racers.getMaxPosition();
        return racers.findSamePositionCars(maxPosition);
    }

    public List<RacingRecord> getResult() {
        return this.result;
    }
}
