package step3.domain;

import step3.RacingRule;

public class RacingCar {

    private RacingRule rule = new RacingRule();
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
