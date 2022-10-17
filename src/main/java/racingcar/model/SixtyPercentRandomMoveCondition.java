package racingcar.model;

public class SixtyPercentRandomMoveCondition implements RandomMoveCondition {

    private static final int MAX_RANDOM_NUMBER_BOUND = 10;
    private static final int MOVABLE_NUMBER_THRESHOLD = 4;

    private final RandomValueGenerator randomValueGenerator;

    public SixtyPercentRandomMoveCondition(final RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    @Override
    public boolean isMovable() {
        return randomValueGenerator.nextValue(MAX_RANDOM_NUMBER_BOUND) >= MOVABLE_NUMBER_THRESHOLD;
    }


}
