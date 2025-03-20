package race;

public class RacingCarFactory {
    private static final RandomNumberGenerator DEFAULT_RANDOM_NUMBER_GENERATOR = new DefaultRandomNumberGenerator();
    private static final PositionPrinter DEFAULT_POSITION_VIEWER = new DefaultPositionPrinter();

    public static RacingCar create(String carName) {
        return RacingCar.create(carName, DEFAULT_RANDOM_NUMBER_GENERATOR, DEFAULT_POSITION_VIEWER);
    }

    public static RacingCar create(String carName, RandomNumberGenerator randomNumberGenerator) {
        return RacingCar.create(carName, randomNumberGenerator, DEFAULT_POSITION_VIEWER);
    }

    public static RacingCar create(String carName, PositionPrinter positionPrinter) {
        return RacingCar.create(carName, DEFAULT_RANDOM_NUMBER_GENERATOR, positionPrinter);
    }

    public static RacingCar create(String carName, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        return RacingCar.create(carName, randomNumberGenerator, positionPrinter);
    }
}
