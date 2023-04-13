package racing;

public class RacingRule {

    private static int BASE_NUMBER = 4;

    // 인스턴스화 방지
    private RacingRule() {
        throw new AssertionError();
    }

    public static int goOrStop(int number) {
        if(number >= BASE_NUMBER){
            return go();
        }
        return stop();
    }

    public static int go() {
        return 1;
    }

    public static int stop() {
        return 0;
    }
}
