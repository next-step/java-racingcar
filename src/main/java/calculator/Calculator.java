package calculator;

public class Calculator {
    private static final int OPERATION_UNIT = 2;
    private static final int FIRST = 0;

    public Integer calculate(String input) {
        String[] inputValues = separateInput(input);
        OperatorReader operatorReader = new OperatorReader();
        Integer result = Integer.valueOf(inputValues[FIRST]);

        for(int i = 1; i < inputValues.length; i += OPERATION_UNIT) {
            Operator operator = operatorReader.readOperator(inputValues[i]);
            Integer secondOperand = Integer.valueOf(inputValues[i+1]);
            result = operator.operate(result, secondOperand);
        }

        return result;
    }

    private String[] separateInput(String input) {
        InputReader inputReader = new InputReader();
        return inputReader.separate(input);
    }
}
