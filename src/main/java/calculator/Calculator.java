package calculator;

import resource.StringResources;
import util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    private final String equation;
    private final String[] elements;

    public Calculator(String equation) throws IllegalArgumentException {

        this.equation = equation;
        verifyEmptyEquation();

        elements = equation.split(" ");
        verifyElementsLength();
    }

    public int calculate() throws IllegalArgumentException, ArithmeticException {

        int result = Integer.parseInt(elements[0]);

        for (int i = 1; i < elements.length; i = i + 2) {
            Operator operator = Operator.of(elements[i]);
            result = operator.calculate(result, Integer.parseInt(elements[i + 1]));
        }

        return result;
    }

    private void verifyEmptyEquation() throws IllegalArgumentException {

        if (StringUtils.isBlank(equation)) {
            throw new IllegalArgumentException(StringResources.ERR_INCORRECT_EQUATION);
        }
    }

    private void verifyElementsLength() {

        if (elements.length % 2 == 0) {
            throw new IllegalArgumentException(StringResources.ERR_INCORRECT_EQUATION);
        }
    }
}