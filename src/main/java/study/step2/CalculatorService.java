package study.step2;

import study.step2.validation.CalculatorValidator;

public class CalculatorService {

    CalculatorService() {
    }

    public int Calculate(String inputs) throws IllegalArgumentException {
        CalculatorValidator.validateEmpty(inputs);

        String[] values = inputs.split(" ");
        int result = parseInt(values[0]);

        for(int i=1; i<values.length; i+=2) {
            result = Calculator.operate(values[i], result, parseInt(values[i+1]));
        }

        return result;
    }

    public int parseInt(String value) {
        return CalculatorValidator.validateStringToNumber(value);
    }

}
