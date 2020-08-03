package racingcar;

public class Car {
    private static final int THRESHOLD = 4;
    private int position;

    public Car() {
        this.position = 1;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int fuel) {
        if (fuel >= THRESHOLD) {
            this.position ++;
        }
    }

    public static Car createCar() {
        return new Car();
    }
}
