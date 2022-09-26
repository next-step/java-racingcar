package step3.models;

public class Car {
    private static final int MIN_NUM_TO_MOVE = 4;
    private final int position;

    public Car() {
        this.position = 0;
    }

    private Car(int position) {
        this.position = position;
    }

    public Car move(int number) {
        if (number >= MIN_NUM_TO_MOVE) {
            return new Car(this.position + 1);
        }
        return this;
    }

    public int getPosition() {
        return this.position;
    }
}
