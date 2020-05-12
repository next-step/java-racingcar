package step2.calculator;

public class StringCalculator {

    public int calculate(String input) {
        String[] parsedInputs = InputParser.parseInput(input);
        int firstNumber = Integer.parseInt(parsedInputs[0]);
        int length = parsedInputs.length;
        int result = 0;
        
        for (int i = 1; i < length; i += 2) {
            Operator operator = Operator.getOperator(parsedInputs[i]);
            int nextNumber = Integer.parseInt(parsedInputs[i + 1]);
            result = operator.calculate(firstNumber, nextNumber);
            firstNumber = result;
        }
        return result;
    }
}
