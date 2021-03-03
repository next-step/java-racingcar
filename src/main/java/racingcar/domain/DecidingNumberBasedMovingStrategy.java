package racingcar.domain;

public class DecidingNumberBasedMovingStrategy implements MovingStrategy {

    private static final int DECIDING_NUMBER=4;

    private static final int MAX_RANDOM_NUM=9;

    private static final int MIN_RANDOM_NUM=0;

    private final NumberGenerator numberGenerator;

    public DecidingNumberBasedMovingStrategy() {
      this(new RandomNumberGenerator(MAX_RANDOM_NUM,MIN_RANDOM_NUM));
    }

    public DecidingNumberBasedMovingStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        return (numberGenerator.generate()>=DECIDING_NUMBER);
    }

}
