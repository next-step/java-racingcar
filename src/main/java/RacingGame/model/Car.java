package RacingGame.model;

public class Car {
    private static final int INITAIL_CAR_POSITION = 0;
    private static final String DEFAULT_CAR_NAME = "NULL";

    private final Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = Position.valueOf(position);
    }

    public Car() {
        this(DEFAULT_CAR_NAME, INITAIL_CAR_POSITION);
    }

    public Car(int position) {
        this(DEFAULT_CAR_NAME, position);
    }

    public Car(String name) {
        this(name, INITAIL_CAR_POSITION);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(MovableStrategy strategy) {
        if (strategy.movable()) {
            move();
        }
    }

    private void move() {
        this.position = position.increase();
    }

    public String name() {
        return name.getName();
    }

    public boolean isPositionAt(int position) {
        return this.position.isValueEquals(position);
    }
}