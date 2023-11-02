package Calculator;

public class Calculator {
    public static int cal(String input) {
        if (isBlank(input)) {
            return 0;
        }
        if (containsDelimiter(input)){
            return sum(input, "[,:]");
        }

        return parse(input);
    }

    private static boolean containsDelimiter(String input) {
        return input.contains(",") || input.contains(":");
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
