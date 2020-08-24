package racingcar.utils;

import java.util.List;

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

    public static String getNames(List<String> namesList, String delimiter) {
        StringBuffer sb = new StringBuffer();
        sb.append(namesList.get(0));
        for (int i = 1; i < namesList.size() ; i++) {
            sb.append(delimiter + namesList.get(i));
        }
        return sb.toString();
    }
}
