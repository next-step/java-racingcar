package racingcar.util;

public class StateUtil {
    private final static String STATE = "-";

    public static String makeStateLine(Integer r) {
        return String.valueOf(new char[r])
                .replace("\0", STATE);
    }
}
