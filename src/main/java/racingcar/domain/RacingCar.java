package racingcar.domain;

public class RacingCar {
    private final static int COUNT_ADVANCE = 1;
    private final static int CONDITION_MOVE = 4;
    private int position;

    public RacingCar() {
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= CONDITION_MOVE) {
            move();
        }
    }

    public void move() {
        this.position += COUNT_ADVANCE;
    }

    public int getPosition() {
        return position;
    }
}
