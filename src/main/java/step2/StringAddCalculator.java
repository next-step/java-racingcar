package step2;

public class StringAddCalculator {
    static final int ZERO = 0;
    static final int CUSTOM_DELIMETER_INDEX = 2;
    static final int CUSTOM_INPUT_BEGIN_INDEX = 4;

    public static int splitAndSum(String input) {
        if (isNotEmpty(input)) return ZERO;
        String[] strNumbers = getStrNumbers(input);
        return calculate(strNumbers);
    }


    public static String[] getStrNumbers(String input) {
        return getInput(input).split(getDelimeter(input));
    }

    public static String getDelimeter(String input) {
        if (isCustum(input)) return String.valueOf(input.charAt(CUSTOM_DELIMETER_INDEX));
        return ",|:";
    }

    public static String getInput(String input) {
        if (isCustum(input)) return input.substring(CUSTOM_INPUT_BEGIN_INDEX);
        return input;
    }

    public static int calculate(String[] strNumbers) {
        int sum = 0;
        for (String strNumber : strNumbers) {
            int number = Integer.parseInt(strNumber);
            if (number < 0) throw new RuntimeException();
            sum += number;
        }
        return sum;
    }

    public static boolean isCustum(String input) {
        return input.contains("//");
    }

    public static boolean isNotEmpty(String input) {
        return input == null || input.isBlank();
    }
}