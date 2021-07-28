package step2;

public class Calculator {

    public static long calculate(String input){

        String[] tokens = InputSeparator.separate(input);

        long result = Long.parseLong(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            ArithmeticOperator operator = ArithmeticOperator.of(tokens[i]);
            long operand = Long.parseLong(tokens[i + 1]);
            result = operator.operate(result, operand);
        }
        return result;
    }
}
