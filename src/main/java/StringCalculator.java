public class StringCalculator {
    public static String[] split(String input) {
        return input.split(" ");
    }

    public static void isBlank(String input) {
        if (input.equals("") || input.equals(" ") || input == null) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_EMPTY);
        }
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static int calculate(String[] splitInput) {
        int result = toInt(splitInput[0]);

        for (int i = 2; i < splitInput.length ; i += 2) {
            result = Operator.result(splitInput[i-1], result, toInt(splitInput[i]));
        }

        return result;
    }

    public static int calculateResult(String input) {
        isBlank(input);
        return calculate(split(input));
    }
}
