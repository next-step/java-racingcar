package study.step3.car;

public class RacingCar {

    private static final int START_POSITION = 0;
    private static final int MOVE_CRITERIA = 4;
    private int position;

    public RacingCar() {
        this.position = START_POSITION;
    }

    public void move(int number) {
        if (number >= MOVE_CRITERIA) {
            this.position++;
        }
    }

    public int getCurrentPosition() {
        return this.position;
    }
}
