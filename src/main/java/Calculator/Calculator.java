package Calculator;

public class Calculator {

    public static final String COMMA = ",";

    public static int cal(String input) {
        if (isBlank(input)) {
            return 0;
        }
        if (isContains(input)){
            return sum(input, COMMA);
        }

        return parse(input);
    }

    private static boolean isContains(String input) {
        return input.contains(COMMA);
    }

    private static int sum(String input, String delimiter) {
        int sum = 0;
        String[] values = input.split(delimiter);
        for (String value : values) {
            sum += parse(value);
        }
        return sum;
    }

    private static int parse(String input) {
        return Integer.parseInt(input);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
