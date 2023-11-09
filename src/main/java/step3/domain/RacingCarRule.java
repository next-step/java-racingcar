package step3.domain;

public class RacingCarRule {

    static private int MOVABLE_LOWER_BOUND = 4;

    public boolean canMove(int movingCondition) {
        return movingCondition >= MOVABLE_LOWER_BOUND;
    }

}
