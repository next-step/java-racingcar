package racingcar;

public class RacingCar {
    private final static int MOVE_THRESHOLD = 3;
    private final static int MOVE = 1;
    private final static int STAY = 0;
    private int movement;

    public RacingCar() {
        this.movement = 0;
    }

    public int move(int condition) {
        this.movement += condition > MOVE_THRESHOLD ? MOVE : STAY;
        return movement;
    }
}
