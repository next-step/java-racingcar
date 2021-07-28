package step2;

public class Calculator {

    private static boolean checkInputValid(String input) {
        return input != null && !input.equals("");
    }

    public static long calculate(String input){
        if (!checkInputValid(input))
            throw new IllegalArgumentException();

        String[] tokens = input.split(" ");

        long result = Long.parseLong(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            ArithmeticOperator operator = ArithmeticOperator.of(tokens[i]);
            long operand = Long.parseLong(tokens[i + 1]);
            result = operator.operate(result, operand);
        }
        return result;
    }
}
