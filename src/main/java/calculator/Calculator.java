package calculator;

public class Calculator {
    public static int calc(String str) {
        int sum = 0;
        if (isBlank(str)) {
            return 0;
        }
        return sum;
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }
}
