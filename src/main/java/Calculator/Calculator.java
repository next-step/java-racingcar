package Calculator;

public class Calculator {

    public static final String COMMA = ",";
    public static final String COLON = ":";

    public static int cal(String input) {
        if (isBlank(input)) {
            return 0;
        }
        if (isContains(input, COMMA)){
            return sum(input, COMMA);
        }
        if (isContains(input, COLON)){
            return sum(input, COLON);
        }

        return parse(input);
    }

    private static boolean isContains(String input, String delimiter) {
        return input.contains(delimiter);
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
