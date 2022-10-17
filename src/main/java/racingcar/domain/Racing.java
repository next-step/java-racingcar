package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.NumberGenerateStrategy;
import racingcar.strategy.RandomNumberGenerateStrategy;

public class Racing {

    private final NumberGenerateStrategy DEFAULT_STRATEGY = new RandomNumberGenerateStrategy();

    private final Racers racers;
    private final List<GameRecord> result = new ArrayList<>();
    private final NumberGenerateStrategy strategy;

    public Racing(final List<String> carNames) {
        this.racers = new Racers(carNames);
        this.strategy = DEFAULT_STRATEGY;
    }

    public Racing(final List<String> carNames, final NumberGenerateStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("NumberGenerateStrategy 객체가 누락되었습니다.");
        }

        this.racers = new Racers(carNames);
        this.strategy = strategy;
    }

    public void race(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            racers.moveAll(strategy);
            result.add(GameRecord.from(racers));
        }
    }

    public List<Car> winners() {
        int maxPosition = racers.getMaxPosition();
        return racers.findSamePositionCars(maxPosition);
    }

    public List<GameRecord> getResult() {
        return this.result;
    }
}
