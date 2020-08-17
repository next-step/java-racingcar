package racingcar.utils;


public class StringUtils {
    public static String repeat(String step, int counts) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < counts; j++) {
            sb.append(step);
        }
        return sb.toString();
    }
}
