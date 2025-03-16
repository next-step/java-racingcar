package calculator;

public class StringCalculator {
    private static final String regex = ",";

    public static int cal(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return sum(split(str));
    }

    private static String[] split(String str) {
        return str.split(regex);
    }

    private static int sum(String[] strings) {
        int result = 0;
        for (String s : strings) {
            result += toInts(s);
        }
        return result;
    }

    private static int toInts(String s) {
        return Integer.parseInt(s);
    }
}
