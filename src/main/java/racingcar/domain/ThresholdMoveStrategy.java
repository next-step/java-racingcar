package racingcar.domain;

public class ThresholdMoveStrategy implements MoveStrategy {

    private final int threshold;
    private final NumberGenerator numberGenerator;

    public ThresholdMoveStrategy(int threshold, NumberGenerator numberGenerator) {
        this.threshold = threshold;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean canMove() {
        return numberGenerator.generate() >= threshold;
    }
}
