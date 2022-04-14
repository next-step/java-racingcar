package racingcar;

public class RacingCar {
    private final static int MOVE_THRESHOLD = 3;
    private final static int MOVE = 1;
    private final static int STAY = 0;

    private int movement;
    private String name;

    public RacingCar() {
        this.movement = 0;
    }

    public RacingCar(String name) {
        this();
        this.name = name;
    }

    public int move(int condition) {
        this.movement += condition > MOVE_THRESHOLD ? MOVE : STAY;
        return movement;
    }
}
