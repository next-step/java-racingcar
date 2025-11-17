package carRacing;

public class RacingCar {

    public static final int MOVE_CONDITION = 4;
    private Position position;
    private CarName name;

    public RacingCar(String name) {
        this(new Position(), new CarName(name));
    }

    public RacingCar(Position position, CarName name) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }

    private void movePosition() {
        position.plus();
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION) {
            movePosition();
        }
    }

    public boolean isGreaterThanPosition(Position other) {
        return position.isGreaterThan(other);
    }
}
