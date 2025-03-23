package racing.config;

import racing.domain.Cars;
import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;

public class GameConfig {
    private final Cars cars;
    private final int attemptCount;
    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    public GameConfig(final Cars cars, final int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public Cars getCars() {
        return cars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
