package step2;

import step2.enums.Operator;

import java.util.Objects;


public class Calculator {

    public int calculate(String input) {
        String[] inputSplitByBlank = splitByBlank(input);
        Validator.valid(inputSplitByBlank);
        return calculate(inputSplitByBlank);
    }

    private int calculate(String[] inputs) {
        int calculated = Integer.parseInt(inputs[0]);
        int length = inputs.length;

        for (int i = 0; i < length; i++)
            calculated = calculate(calculated, inputs, i);

        return calculated;
    }

    private int calculate(int calculated, String[] inputs, int idx) {
        if (isLastIdx(inputs, idx))
            return calculated;

        String input = inputs[idx];
        String nextValue = inputs[idx + 1];

        if (Operator.isOperator(input)) {
            Operator operator = Operator.findOperatorByString(input);
            return operator.calculate(calculated, Integer.parseInt(nextValue));
        }
        return calculated;
    }

    private boolean isLastIdx(String[] inputs, int idx) {
        return inputs.length == idx + 1;
    }

    private String[] splitByBlank(String input) {
        if (Objects.isNull(input) || input.isEmpty())
            throw new IllegalArgumentException();

        return input.split("\\s");
    }

    private static class Validator {

        static void valid(String[] inputs) {
            for (String input : inputs) {
                if (!isValidInput(input))
                    throw new IllegalArgumentException();
            }
        }

        private static boolean isValidInput(String input) {
            return isInteger(input) || Operator.isOperator(input);
        }

        private static boolean isInteger(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

}
