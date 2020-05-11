package step2.calculator;

public class Calculator {

    public int calculate(String input) {
        String[] parsedInput = InputParser.parseInput(input);
        int result = Integer.parseInt(parsedInput[0]);
        int length = parsedInput.length;
        
        for (int i = 1; i < length; i += 2) {
            Operator operator = Operator.getOperator(parsedInput[i]);
            int nextNumber = Integer.parseInt(parsedInput[i + 1]);
            result = operator.operate(result, nextNumber);
        }
        return result;
    }
}
