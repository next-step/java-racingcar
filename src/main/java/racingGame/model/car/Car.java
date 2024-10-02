package racingGame.model.car;

public class Car {

    private static final int MINIMUM_MOVEMENT_VALUE = 4;

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int number) {
        if (number >= MINIMUM_MOVEMENT_VALUE) {
            this.position++;
        }
    }
}
