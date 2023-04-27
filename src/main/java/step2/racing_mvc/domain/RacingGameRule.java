package step2.racing_mvc.domain;

public class RacingGameRule {

    private static int MOVABLE_NUMBER = 4;

    // 인스턴스화 방지
    private RacingGameRule() {
        throw new AssertionError();
    }

    public static boolean moveOrStop(int randomNumber) {
        return randomNumber >= MOVABLE_NUMBER;
    }
}