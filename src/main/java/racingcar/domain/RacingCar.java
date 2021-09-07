package racingcar.domain;

public class RacingCar {

    private final static int COUNT_ADVANCE = 1;
    private final static int CONDITION_MOVE = 4;
    private String name;
    private int position;

    public RacingCar() {
    }

    public RacingCar(String name) {
        this.name = name;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= CONDITION_MOVE) {
            move();
        }
    }

    public void move() {
        this.position += COUNT_ADVANCE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
