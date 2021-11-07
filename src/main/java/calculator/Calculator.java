package calculator;

import static calculator.Validator.argumentValidation;
import static calculator.Validator.operatorValidation;

public class Calculator {
    private static final String SPACE = " ";

    public int execute(String input) {
        argumentValidation(input);

        String[] inputs = input.split(SPACE);
        Number calResult = new Number(inputs[0]);

        for(int i = 1; i < inputs.length - 1; i += 2 ) {
            Number nextNumber = new Number(inputs[i+1]);
            calResult = calculate(calResult, inputs[i], nextNumber);
        }

        return calResult.getValue();
    }

    private Number calculate(Number input1, String operatorInput, Number input2) {
        operatorValidation(operatorInput);
        Operator operator = Operator.of(operatorInput);

        return operator.execute(input1, input2);
    }

}
