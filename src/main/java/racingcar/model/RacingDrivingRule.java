package racingcar.model;

public class RacingDrivingRule implements DrivingRule {
    public static final int MOVEMENT_CRITERIA = 4;

    private NumberGenerationStrategy numberGenerationStrategy;

    private RacingDrivingRule(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    public static RacingDrivingRule createDefault() {
        NumberGenerationStrategy numberGenerationStrategy = new RandomNumberGenerator();
        return new RacingDrivingRule(numberGenerationStrategy);
    }

    public static RacingDrivingRule createWithNumberGenerator(NumberGenerationStrategy numberGenerationStrategy) {
        return new RacingDrivingRule(numberGenerationStrategy);
    }

    @Override
    public boolean isMovable() {
        int discriminantValue = numberGenerationStrategy.generate();
        return discriminantValue >= MOVEMENT_CRITERIA;
    }
}
