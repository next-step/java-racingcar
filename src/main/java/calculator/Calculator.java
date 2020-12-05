package calculator;

public class Calculator {
    public Integer calculate(String input) {
        String[] inputValues = seperateInput(input);
        OperatorReader operatorReader = new OperatorReader();
        Integer result = Integer.valueOf(inputValues[0]);
        int i = 1;
        while (i <= inputValues.length - 1) {
            Operator operator = operatorReader.readOperator(inputValues[i]);
            i ++;
            Integer second = Integer.valueOf(inputValues[i]);
            i ++;
            result = operator.operate(result, second);
        }
        return result;
    }

    private String[] seperateInput(String input) {
        InputReader inputReader = new InputReader();
        return inputReader.separate(input);
    }
}
