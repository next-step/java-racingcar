package race;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CRITERIA = 4;
    private final CarName name;
    private final Position position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
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

    public Position getMaxPosition(Position comparePosition) {
        return this.position.getMax(comparePosition);
    }

    public boolean isSamePosition(Position comparePosition) {
        return this.position.equals(comparePosition);
    }
}
