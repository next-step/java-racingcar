package carRacing;

public class RacingCar {

    public static final int MOVE_CONDITION = 4;
    private Position position;
    private CarName name;

    public RacingCar(String name) {
        this.name = new CarName(name);
        this.position = new Position();
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

    public boolean isGreaterThanPosition(Position position) {
        return this.position.value() >= position.value();
    }
}
