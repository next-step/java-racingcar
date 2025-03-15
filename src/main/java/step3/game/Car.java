package step3.game;

public class Car {

    public static final int START_LINE = 0;

    private Integer moveSteps;

    public Car() {
        this.moveSteps = START_LINE;
    }

    public void move() {
        moveSteps++;
    }

    public Integer getDistance() {
        return moveSteps;
    }
}
