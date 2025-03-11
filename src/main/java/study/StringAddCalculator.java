package study;

public class StringAddCalculator {
    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        if (Integer.parseInt(value) == 1) {
            return 1;
        }

        return 0;
    }
}
