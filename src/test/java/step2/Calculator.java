package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {

    int stringCalculatingProcessor(String rawInput) {
        String[] inputArithmeticInventory = rawInput.split(" ");
        String operand = "";
        ExceptionTest exception = new ExceptionTest();
        int sum = 0;

        for (int i = 0; i < inputArithmeticInventory.length; i++) {
            String currentArithmeticInput = inputArithmeticInventory[i];

            if (exception.isStringEmpty(currentArithmeticInput)) {
                break;
            }
            if (exception.isArithmeticExpression(currentArithmeticInput)) {
                operand = currentArithmeticInput;
                continue;
            }
            if (i == 0) {
                sum = Integer.parseInt(currentArithmeticInput);
                continue;
            }
            sum = processCalculating(operand, new int[]{sum, Integer.parseInt(currentArithmeticInput)});
        }

        return sum;
    }

    private int processCalculating(String operator, int[] parameters) {
        int parameter1 = parameters[0];
        int parameter2 = parameters[1];

        if (operator.equals("+")) {

            return parameter1 + parameter2;
        }

        if (operator.equals("-")) {

            return parameter1 - parameter2;
        }

        if (operator.equals("*")) {

            return parameter1 * parameter2;
        }

        if (operator.equals("/")) {

            return parameter1 / parameter2;
        }

        return 0;
    }

    @ParameterizedTest
    @ValueSource(strings = {"6 / 3 - 5", "6 * 3 - 5", "0", "1+1"})
    void testCalculator(String inputValue) {
        assertThat(stringCalculatingProcessor(inputValue)).isInstanceOf(Integer.class);
    }
}
