package race;

public class RacingCar {
    private final int racingNumber;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;
    private final PositionOutputViewer positionOutputViewer;

    private RacingCar(int racingNumber, RandomNumberGenerator randomNumberGenerator, PositionOutputViewer positionOutputViewer) {
        this.racingNumber = racingNumber;
        this.randomNumberGenerator = randomNumberGenerator;
        this.positionOutputViewer = positionOutputViewer;
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
        positionOutputViewer.showPosition(racingNumber, position);
    }

    static RacingCar create(int racingNumber, RandomNumberGenerator randomNumberGenerator, PositionOutputViewer positionOutputViewer) {
        return new RacingCar(racingNumber, randomNumberGenerator, positionOutputViewer);
    }
}
