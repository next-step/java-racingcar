package Calculator;

public class Calculator {
    public static int cal(String input) {
        if(isBlank(input)) {
            return 0;
        }
        return parse(input);
    }

    private static int parse(String input) {
        return Integer.parseInt(input);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
