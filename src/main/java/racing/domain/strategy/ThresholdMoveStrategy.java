package racing.domain.strategy;

import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;

public class ThresholdMoveStrategy implements MoveStrategy {

    private static final int THRESHOLD = 4;

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    public ThresholdMoveStrategy(){}

    public ThresholdMoveStrategy(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean shouldMove() {
        return numberGenerator.generate() >= THRESHOLD;
    }
}
