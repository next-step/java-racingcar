package calculator;

public class StringAddCalculator {

    public static int sum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str);
    }

}
