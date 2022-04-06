package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        if (value == null || value.isBlank()) {
            return 0;
        }
        int result = 0;
        String[] splitedString = value.split(",|:");
        for (String each : splitedString) {
            result += Integer.parseInt(each);
        }
        return result;
    }
}
