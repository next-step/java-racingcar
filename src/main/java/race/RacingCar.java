package race;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private final CarName name;
    private final Position position;

    private RacingCar(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public static boolean validateName(String carName) {
        return !carName.isEmpty() && carName.length() <= MAX_NAME_LENGTH;
    }

    private boolean shouldMove(int num) {
        return num >= 4;
    }

    public Position moveWithSeed(int seed) {
        if (shouldMove(seed)) {
            return this.position.move();
        }
        return this.position;
    }

    static RacingCar create(String racingName, int position) {
        return new RacingCar(racingName, position);
    }

    public CarName getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getMaxPosition(int value) {
        return Math.max(this.position.getValue(), value);
    }

    public boolean isSamePosition(int value) {
        return this.position.getValue() == value;
    }
}
