package StringAdder;

import java.util.List;

public class StringAdder {

    public static final int ZERO = 0;

    public int splitAndSum(String input) {
        if (isBlank(input)) {
            return ZERO;
        };

        String delimiter = findDelimiter(input);

        return sumAll(splitString(input, delimiter));
    }

    public boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    public int toInt(String str) {
        return Integer.parseInt(str);
    }

    public String[] splitString(String str, String delimiter) {
        return str.split(delimiter);
    }

    public boolean isPositive(String input) {
        if (toInt(input) < 0)
            throw new IllegalArgumentException("input must be a non-negative integer");
        return true;
    }

    public int sumAll(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.contains("//")) {
                continue;
            }

            if (number.contains("\\n")) {
                number = number.split("n")[1];
            }

            if (isPositive(number)) {
                sum += toInt(number);
            }
        }
        return sum;
    }

    public String findDelimiter(String str) {
        if (str.contains(":")) {
            return ":";
        }

        if (str.contains("//") && str.contains("\\n")) {
            int start = str.indexOf("//") + "//".length();
            int end = str.indexOf("\\n");
            return str.substring(start,end);
        }

        return ",";
    }
}
