package racing;

public class RacingRule {

    private static int MOVABLE_NUMBER = 4;

    // 인스턴스화 방지
    private RacingRule() {
        throw new AssertionError();
    }

    public static boolean moveOrStop(int randomNumber) {
        return randomNumber >= MOVABLE_NUMBER;
    }
}
