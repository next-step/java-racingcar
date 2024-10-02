package racinggame.domain;

public class Car {
    public static final int MINIMUM_MOVE_NUMBER = 4;
    public static final int DEFAULT_POSITION = 0;
    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String name) {
        return new Car(name, DEFAULT_POSITION);
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
