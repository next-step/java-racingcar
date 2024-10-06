package race.domain;


public class RacingCar {
    private static final int MOVE_CONDITION_NUMBER = 4;
    private Position position;
    private CarName name;

    public RacingCar(String name, Position position) {

        this.name = new CarName(name);
        this.position = position;
    }

    public RacingCar(String name, int position) {
        this(name, new Position(position));
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public String getName() {
        return this.name.getName();
    }

    public void moveForward(int value) {
        if (isMovable(value)) {
            this.position.move();
        }
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public boolean hasSamePosition(int position) {
        return this.position.hasSamePosition(position);
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

}