package race;

public class RacingCarFactory {
    private static final RandomNumberGenerator DEFAULT_RANDOM_NUMBER_GENERATOR = new DefaultRandomNumberGenerator();
    private static final PositionPrinter DEFAULT_POSITION_VIEWER = new DefaultPositionPrinter();

    public static RacingCar create(int racingNumber) {
        return RacingCar.create(racingNumber, DEFAULT_RANDOM_NUMBER_GENERATOR, DEFAULT_POSITION_VIEWER);
    }

    public static RacingCar create(int racingNumber, RandomNumberGenerator randomNumberGenerator) {
        return RacingCar.create(racingNumber, randomNumberGenerator, DEFAULT_POSITION_VIEWER);
    }

    public static RacingCar create(int racingNumber, PositionPrinter positionPrinter) {
        return RacingCar.create(racingNumber, DEFAULT_RANDOM_NUMBER_GENERATOR, positionPrinter);
    }

    public static RacingCar create(int racingNumber, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        return RacingCar.create(racingNumber, randomNumberGenerator, positionPrinter);
    }
}
