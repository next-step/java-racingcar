package racinggame.domain;

public class Car {
    public static final int MINIMUM_MOVE_NUMBER = 4;
    private int position;

    private Car() {
        this.position = 0;
    }

    public static Car create() {
        return new Car();
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isMoveable(number)) {
            position++;
        }
    }

    private boolean isMoveable(int number) {
        return number >= MINIMUM_MOVE_NUMBER;
    }
}
