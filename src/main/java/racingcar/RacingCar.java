package racingcar;

public class RacingCar {

    private static final int STARTING_POSITION = 0;
    private static final int MINIMUM_VALUE_TO_MOVE = 4;

    private int carPosition;

    public RacingCar() {
        this.carPosition = STARTING_POSITION;
    }

    public void action(int value) {
        if (value >= MINIMUM_VALUE_TO_MOVE) {
            this.move();
        }
    }

    private void move() {
        this.carPosition++;
    }


    public int getCarPosition() {
        return this.carPosition;
    }
}