package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;

public class Racing {

    private final MovingStrategy DEFAULT_STRATEGY = new RandomMovingStrategy();

    private final Racers racers;
    private final List<GameRecord> result = new ArrayList<>();
    private final MovingStrategy strategy;

    public Racing(final List<String> carNames) {
        this.racers = new Racers(carNames);
        this.strategy = DEFAULT_STRATEGY;
    }

    public Racing(final List<String> carNames, final MovingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("MovingStrategy 객체가 누락되었습니다.");
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
