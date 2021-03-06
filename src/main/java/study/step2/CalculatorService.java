package study.step2;

import study.step2.validation.CalculatorValidator;

public class CalculatorService {

    private Calculator calculator;

    CalculatorService() {
        this.calculator = new Calculator();
    }

    public int Calculate(String inputs) throws IllegalArgumentException {
        CalculatorValidator.validateEmpty(inputs);

        String[] values = inputs.split(" ");
        int result = parseInt(values[0]);

        for(int i=1; i<values.length; i+=2) {
            String operator = CalculatorValidator.validateOperator(values[i]);
            result = calculator.operate(operator, result, parseInt(values[i+1]));
        }

        return result;
    }

    public int parseInt(String value) {
        return CalculatorValidator.validateStringToNumber(value);
    }

}
