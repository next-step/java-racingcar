package racing;

public class RacingRule {

    private static int MOVABLE_NUMBER = 4;

    // 인스턴스화 방지
    private RacingRule() {
        throw new AssertionError();
    }

    public static int moveOrStop(int number) {
        if (number >= MOVABLE_NUMBER) {
            return move();
        }
        return stop();
    }

    public static int move() {
        return 1;
    }

    public static int stop() {
        return 0;
    }
}
