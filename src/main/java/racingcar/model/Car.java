package racingcar.model;

public class Car {

    private static final int MOVE_FORWARD_CONDITION = 4;
    private static final int DEFAULT_POSITION = 0;

    private int position;
    private final Name name;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void moveForward(int moveCondition) {
        if (moveCondition >= MOVE_FORWARD_CONDITION) {
            this.position++;
        }
    }

    public boolean isSamePosition(int comparePosition) {
        return position == comparePosition;
    }

    public int compareMaxPosition(int comparePosition) {
        return Math.max(position, comparePosition);
    }

    public String getCarName() {
        return name.getCarName();
    }

    public int getPosition() {
        return position;
    }

}
