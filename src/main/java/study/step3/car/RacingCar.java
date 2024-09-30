package study.step3.car;

public class RacingCar {

    private static final int START_POSITION = 0;
    private int position;

    public RacingCar() {
        this.position = START_POSITION;
    }

    public void move() {
        this.position++;
    }

    public int getCurrentPosition() {
        return this.position;
    }
}
