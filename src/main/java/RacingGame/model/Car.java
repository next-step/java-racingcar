package RacingGame.model;

public class Car {
    private static final int CAR_LENGTH_EXCEED = 5;
    private static final int DEFAULT_MOVE_DISTANCE = 1;
    private static final int INITAIL_CAR_POSITION = 0;
    private static final String CARNAME_LENGTH_EXCEED = String.format("차량의 이름은 %d 글자가 넘어갈 수 없습니다", CAR_LENGTH_EXCEED);
    private static final String DEFAULT_CAR_NAME = "NULL";

    private final String name;
    private int position;

    public Car(String name, int position) {
        if (name.length() > CAR_LENGTH_EXCEED) {
            throw new IllegalArgumentException(CARNAME_LENGTH_EXCEED);
        }

        this.name = name;
        this.position = position;
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
        return position;
    }

    public void move(MovableStrategy strategy) {
        if (strategy.movable()) {
            move();
        }
    }

    private void move() {
        position += DEFAULT_MOVE_DISTANCE;
    }

    public String name() {
        return this.name;
    }

    public boolean isPositionAt(int position) {
        return this.position == position;
    }
}