package race;

public class RacingCar implements Comparable<RacingCar> {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;
    private final PositionPrinter positionPrinter;

    private RacingCar(String name, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
        this.positionPrinter = positionPrinter;
    }

    @Override
    public int compareTo(RacingCar other) {
        return Integer.compare(this.position, other.position);
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
        positionPrinter.printPosition(name, position);
    }

    static RacingCar create(String racingName, RandomNumberGenerator randomNumberGenerator, PositionPrinter positionPrinter) {
        return new RacingCar(racingName, randomNumberGenerator, positionPrinter);
    }

    public String getName() {
        return name;
    }
}
