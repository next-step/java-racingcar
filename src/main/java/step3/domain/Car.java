package step3.domain;

public class Car {

    private static final int DEFAULT_CAR_POSITION = 1;
    private static final int ACCEPT_MOVE_NUMBER = 4;

    private int position;

    public Car() {
        position = DEFAULT_CAR_POSITION;
    }

    public Car(final Car car) {
        this.position = car.position;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(final int randomNumber) {
        if (randomNumber >= ACCEPT_MOVE_NUMBER) {
            position++;
        }
    }
}
