package study03.racing.car;

public class RacingCar {

    private final Engine engine = new Engine();
    private final Distance moveDistance = new Distance(1);

    public boolean move() {
        if (engine.isRun()) {
            this.moveDistance.addDistance();
            return true;
        }
        return false;
    }

    public String currentMoveDistance() {
        return moveDistance.totalMoved();
    }

    @Override
    public String toString() {
        return String.format("자동차 (주행상태:%s)", currentMoveDistance());
    }

}
