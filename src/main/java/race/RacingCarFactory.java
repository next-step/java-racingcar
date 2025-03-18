package race;

public class RacingCarFactory {
    private static final RandomNumberGenerator DEFAULT_RANDOM_NUMBER_GENERATOR = new DefaultRandomNumberGenerator();
    private static final PositionOutputViewer DEFAULT_POSITION_VIEWER = new DefaultPositionOutputViewer();

    public static RacingCar create(int racingNumber) {
        return RacingCar.create(racingNumber, DEFAULT_RANDOM_NUMBER_GENERATOR, DEFAULT_POSITION_VIEWER);
    }

    public static RacingCar create(int racingNumber, RandomNumberGenerator randomNumberGenerator) {
        return RacingCar.create(racingNumber, randomNumberGenerator, DEFAULT_POSITION_VIEWER);
    }

    public static RacingCar create(int racingNumber, PositionOutputViewer positionOutputViewer) {
        return RacingCar.create(racingNumber, DEFAULT_RANDOM_NUMBER_GENERATOR, positionOutputViewer);
    }

    public static RacingCar create(int racingNumber, RandomNumberGenerator randomNumberGenerator, PositionOutputViewer positionOutputViewer) {
        return RacingCar.create(racingNumber, randomNumberGenerator, positionOutputViewer);
    }
}
