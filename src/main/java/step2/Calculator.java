package step2;

public class Calculator {

    private static boolean checkInputValid(String input) {
        return input != null && !input.equals("");
    }

    private static boolean checkOperatorValid(String operator) {
        return operator.equals("+") || operator.equals("-") ||
                operator.equals("*") || operator.equals("/");
    }

    public static long calculate(String input){
        if (!checkInputValid(input))
            throw new IllegalArgumentException();

        String[] tokens = input.split(" ");

        long result = Long.parseLong(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            Long operand = Long.parseLong(tokens[i + 1]);

            if (!checkOperatorValid(operator))
                throw new IllegalArgumentException();

        }
        return result;
    }
}
