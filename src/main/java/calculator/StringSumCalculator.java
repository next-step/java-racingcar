package calculator;

public class StringSumCalculator {
    public static int calculate(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (String s : input.split(",")) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
