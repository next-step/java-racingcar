package racingcar;

public class Car {

    private static final int DEFAULT_DISTANCE = 0;
    private int position;

    public static Car of() {
        return new Car();
    }

    private Car() {
        this.position = DEFAULT_DISTANCE;
    }

    void move() {
        this.position++;
    }
}
