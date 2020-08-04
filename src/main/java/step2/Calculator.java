package step2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public int stringCalculatingProcessor(String rawInput) {
        String[] inputArithmeticInventory = rawInput.split(" ");
        String operand = "+";
        int sum = 0;
        //TODO: 입력을 어떻게 stream으로 해결 할 수 있을까
        for (int i = 0; i < inputArithmeticInventory.length; i++) {
            String currentArithmeticInput = inputArithmeticInventory[i];

            if (Exceptions.isStringEmpty(currentArithmeticInput)) {
                break;
            }
            if (Exceptions.isArithmeticExpression(currentArithmeticInput)) {
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

    private Integer processCalculating(String operator, int[] parameters) {
        int parameter1 = parameters[0];
        int parameter2 = parameters[1];

        Stream<CalculatingProcess> calculatingStream = Arrays.stream(CalculatingProcess.values());

        return calculatingStream
                .filter(el -> el.getOperand().equals(operator))
                .map(calculator -> calculator.getCalculation(parameter1, parameter2))
                .findFirst().get(); //TODO:어떻게 하면 더 좋게 처리 할 수 있을까.
    }
}
