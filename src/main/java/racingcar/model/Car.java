package racingcar.model;

public class Car {
    public static final int MOVABLE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;

    private final int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this.position = position;
    }

    public boolean move(int number) {
        if (number >= MOVABLE_NUMBER) {
            return true;
        }

        return false;
    }

    public int getPosition() {
        return this.position;
    }
}
