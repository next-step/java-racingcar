import operator.FourArithmeticOperation;
import operator.Operator;

import java.util.Objects;


public class Calculator {

    private FourArithmeticOperation fourArithmeticOperation = new FourArithmeticOperation();

    public int calculate(String input) {
        String[] inputSplitByBlank = splitByBlank(input);
        Validator.valid(inputSplitByBlank);
        return calculate(inputSplitByBlank);
    }

    private int calculate(String[] inputs) {
        int result = Integer.parseInt(inputs[0]);
        int length = inputs.length;

        for (int i = 0; i < length; i++) {
            String input = inputs[i];
            if (fourArithmeticOperation.isOperationSymbol(input)) {
                Operator operator = fourArithmeticOperation.findOperatorByString(input);

                int leftHand = result;
                int rightHand = Integer.parseInt(inputs[i + 1]);
                int calculated = operator.calculate(leftHand, rightHand);
                result = calculated;
            }
        }
        return result;
    }

    private String[] splitByBlank(String input) {
        if (Objects.isNull(input) || input.isEmpty())
            throw new IllegalArgumentException();

        return input.split("\\s");
    }


    private static class Validator {
        private static final FourArithmeticOperation FOUR_ARITHMETIC_OPERATION = new FourArithmeticOperation();

        static void valid(String[] inputs) {
            for (String input : inputs) {
                if (!isValidInput(input))
                    throw new IllegalArgumentException();
            }
        }

        private static boolean isValidInput(String input) {
            return isInteger(input) || isOperator(input);
        }

        private static boolean isInteger(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private static boolean isOperator(String input) {
            return FOUR_ARITHMETIC_OPERATION.isOperationSymbol(input);
        }
    }

}
