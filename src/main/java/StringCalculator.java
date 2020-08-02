public class StringCalculator {

    public static String[] split(String input) {
        return input.split(" ");
    }

    public static void isBlank(String input) {
        if (input.equals(" ") || input == null) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_EMPTY);
        }
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static int calculateSymbols(int firstValue, char operator, int secondValue) {
        if (operator == '+')
            return Operator.plus(firstValue, secondValue);

        if (operator == '-')
            return Operator.minus(firstValue, secondValue);

        if (operator == '*')
            return Operator.multiply(firstValue, secondValue);

        if (operator == '/')
            return Operator.divide(firstValue, secondValue);

        throw new IllegalArgumentException(ExceptionMessage.NOT_ARITHMETIC_SIMBOLS);
    }

    public static int calculate(String[] splitInput) {
        int result = toInt(splitInput[0]);

        for (int i = 0; i < splitInput.length -2 ; i += 2) {
            result = calculateSymbols(result, splitInput[i + 1].charAt(0), toInt(splitInput[i + 2]));
        }
        return result;
    }

    public static int calculateResult(String input) {
        isBlank(input);
        return calculate(split(input));
    }
}
