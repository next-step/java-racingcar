package race;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private final String racingName;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;
    private final PositionPrinter positionPrinter;

    private RacingCar(String racingName, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        this.racingName = racingName;
        this.randomNumberGenerator = randomNumberGenerator;
        this.positionPrinter = positionPrinter;
    }

    public static boolean validateName(String carName) {
        return !carName.isEmpty() && carName.length() <= MAX_NAME_LENGTH;
    }

    private boolean shouldMove(int num) {
        return num >= 4;
    }

    public int move() {
        int randomValue = randomNumberGenerator.generate();
        if (shouldMove(randomValue)) {
            position++;
        }
        return position;
    }

    public void printPosition() {
        positionPrinter.printPosition(racingName, position);
    }

    static RacingCar create(String racingName, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        return new RacingCar(racingName, randomNumberGenerator, positionPrinter);
    }
}
