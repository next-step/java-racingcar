package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        int result = 0;
        if (value == null || value.isBlank()) {
            return 0;
        } else {
            String[] numbers = value.split(",");
            for (String number : numbers) {
                System.out.println("number = " + number);
                result += Integer.parseInt(number);
            }
        }
        return result;
    }
}
