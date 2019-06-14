package step1.util;

public class StringUtil {

    public static boolean isConsistOnlyWhiteSpace(String input) {

        if(input == null) {
            return false;
        }

        return input.trim().isEmpty();
    }
}
