package racing.domain;

public class Condition {
    private static final int VALUE_MIN_NUM = 4;

    public static boolean checkMove(int randomNum) {
        return randomNum >= VALUE_MIN_NUM;
    }

}
