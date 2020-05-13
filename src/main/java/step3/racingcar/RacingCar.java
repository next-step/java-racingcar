package step3.racingcar;

public class RacingCar {

    private static final int START_POSITION = 1;

    private int position;

    public RacingCar() {
        this.position = START_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void movePosition() {
        this.position++;
    }
}
