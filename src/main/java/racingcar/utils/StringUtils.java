package racingcar.utils;


public class StringUtils {

    public static boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static String repeat(String step, int counts) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < counts; j++) {
            sb.append(step);
        }
        return sb.toString();
    }
}
