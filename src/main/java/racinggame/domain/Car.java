package racinggame.domain;

public class Car {
    public static final int MINIMUM_MOVE_NUMBER = 4;
    public static final int DEFAULT_POSITION = 0;
    private int position;

    private Car(int position) {
        this.position = position;
    }

    public static Car create() {
        return new Car(DEFAULT_POSITION);
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
