package stringcalculator;

public class StringCalculator {
    public static int calculate(String input) {
        verifyInput(input);
        String[] split = input.split(" ");
        int result = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i += 2) {
            int firstNumber = result;
            char operator = split[i].charAt(0);
            int secondNumber = Integer.parseInt(split[i + 1]);
            result = operate(firstNumber, operator, secondNumber);
        }
        return result;
    }

    private static void verifyInput(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        if (input.isEmpty())
            throw new IllegalArgumentException();
    }

    private static int operate(int firstNumber, char operator, int secondNumber) {
        if (operator == '-')
            return firstNumber - secondNumber;
        else if (operator == '*')
            return firstNumber * secondNumber;
        else if (operator == '/')
            return firstNumber / secondNumber;
        return firstNumber + secondNumber;
    }
}
