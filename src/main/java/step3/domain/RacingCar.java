package step3.domain;

public class RacingCar {

    private RacingCarRule rule = new RacingCarRule();
    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    public void move(int movingCondition) {
        if (rule.canMove(movingCondition)) {
            distance += 1;
        }
    }

}
