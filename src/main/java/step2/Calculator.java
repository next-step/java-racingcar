package step2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public int stringCalculatingProcessor(String rawInput) {
        String[] inputArithmeticInventory = rawInput.split(" ");
        String operand = "+";
        int total = 0;
        //TODO: 입력을 어떻게 stream으로 해결 할 수 있을까
        for (int i = 0; i < inputArithmeticInventory.length; i++) {
            String currentArithmeticInput = inputArithmeticInventory[i];
            int calculatedTotal = total;
            String finalOperand = operand;

            if (UserInputValidation.isStringEmpty(currentArithmeticInput)) {
                break;
            }

            if (Arrays.stream(CalculatingProcess.values())
                    .anyMatch(el -> el.getOperand().equals(currentArithmeticInput))) {
                operand = currentArithmeticInput;
                continue;
            }

            if (i == 0) {
                total = Integer.parseInt(currentArithmeticInput);
                continue;
            }

            total = Arrays.stream(CalculatingProcess.values())
                    .filter(el -> el.getOperand().equals(finalOperand))
                    .map(calculator -> calculator.getCalculation(calculatedTotal, Integer.parseInt(currentArithmeticInput)))
                    .findFirst().get();
        }

        return total;
    }
}
