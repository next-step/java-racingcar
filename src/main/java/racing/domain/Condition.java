package racing.domain;

public class Condition {
    private static final int VALUE_MIN_NUM = 4;
    private static final int VALUE_MAX_NAME = 5;

    public static boolean checkMove(int randomNum) {
        return randomNum >= VALUE_MIN_NUM;
    }

    public static boolean checkName(String name) {
        return name.length() <= VALUE_MAX_NAME;
    }
}
