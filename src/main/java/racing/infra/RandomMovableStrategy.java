package racing.infra;

import racing.domain.MovableStrategy;

public class RandomMovableStrategy implements MovableStrategy {
    private static final int MOVABLE_NUMBER = 4;

    private RandomNumberGenerator randomNumberGenerator;

    private RandomMovableStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static RandomMovableStrategy of(RandomNumberGenerator randomNumberGenerator) {
        return new RandomMovableStrategy(randomNumberGenerator);
    }

    @Override
    public boolean movable() {
        return randomNumberGenerator.generate().isGreaterThanOrEqualTo(MOVABLE_NUMBER);
    }
}