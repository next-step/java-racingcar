package step3;

public class RacingRule {

    static private int MIN_FORWARD_NUMBER = 4;

    public static boolean canMove(int movingCondition) {
        return movingCondition >= MIN_FORWARD_NUMBER;
    }

}
