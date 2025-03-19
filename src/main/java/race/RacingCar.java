package race;

public class RacingCar {
    private final int racingNumber;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;
    private final PositionPrinter positionPrinter;

    private RacingCar(int racingNumber, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        this.racingNumber = racingNumber;
        this.randomNumberGenerator = randomNumberGenerator;
        this.positionPrinter = positionPrinter;
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
        positionPrinter.printPosition(racingNumber, position);
    }

    static RacingCar create(int racingNumber, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        return new RacingCar(racingNumber, randomNumberGenerator, positionPrinter);
    }
}
