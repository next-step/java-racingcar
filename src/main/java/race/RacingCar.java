package race;

public class RacingCar {
    private final int racingNumber;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;
    private final PositionFormatter positionFormatter;

    public RacingCar(int racingNumber, RandomNumberGenerator randomNumberGenerator, PositionFormatter positionFormatter) {
        this.racingNumber = racingNumber;
        this.randomNumberGenerator = randomNumberGenerator;
        this.positionFormatter = positionFormatter;
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
        System.out.println(positionFormatter.format(racingNumber, position));
    }
}
