package racingcar.domain;

public class ThresholdMoveStrategy implements MoveStrategy {

    private static final int THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public ThresholdMoveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean canMove() {
        return numberGenerator.generate() >= THRESHOLD;
    }
}
