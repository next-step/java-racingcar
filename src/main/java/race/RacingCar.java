package race;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CRITERIA = 4;
    private final CarName name;
    private final Position position;

    public RacingCar(String name) {
        this.name = new CarName(name);
        this.position = new Position();

    }

    public static boolean validateName(String carName) {
        return !carName.isEmpty() && carName.length() <= MAX_NAME_LENGTH;
    }

    private boolean shouldMove(int num) {
        return num >= MOVE_CRITERIA;
    }

    public Position moveWithSeed(int seed) {
        if (shouldMove(seed)) {
            return this.position.move();
        }
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getMaxPosition(int value) {
        return this.position.getMax(value);
    }

    public boolean isSamePosition(int value) {
        return this.position.isSame(value);
    }
}
