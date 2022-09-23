package study;

public class StringAddCalculator {
    public static int splitAndSum(String str) {
        if (isBlank(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    private static boolean isBlank(String str) {
        return str == null || str == "";
    }
}
