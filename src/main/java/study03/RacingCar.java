package study03;

public class RacingCar {

    private final Engine engine = new Engine();
    private int moveDistance = 1;

    public void move() {
        if (engine.isRun()) {
            moveDistance++;
        }
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    @Override
    public String toString() {
        return "자동차";
    }

    //Test Code Only
    public void fixedMove(int fixedValue) {
        if (engine.isFixedRun(fixedValue)) {
            moveDistance++;
        }
    }

}
