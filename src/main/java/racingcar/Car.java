package racingcar;

public class Car {
    private static final int THRESHOLD = 4;
    private static final int START_POINT = 1;

    private int position;

    private Car() {
        this.position = START_POINT;
    }

    public void move(int fuel) {
        if (fuel >= THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public static Car createCar() {
        return new Car();
    }
}
