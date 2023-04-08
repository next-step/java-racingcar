package racingcar;

public class Car {

    public static final int MOVABLE_POWER_CRITERIA = 4;
    public static final int SET_POSITION = 1;

    private int position;

    public Car() {
        this.position = SET_POSITION;
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int power) {
        if (!isMovable(power)) {
            return;
        }
        this.position++;
    }

    private boolean isMovable(int power) {
        return power >= MOVABLE_POWER_CRITERIA;
    }

    public Car clone() {
        return new Car(this.position);
    }

}
