package calculator;

import static java.util.Objects.isNull;

public class Calculator {

    private static final String FOUR_POINT_OPERATION_REG = "[-*/+]";
    private static final String NUMBER_REG = "[0-9]+$";


    public String calculate(String inputString) {

        String[] inputs = splitInputString(inputString);

        FourPointOperation operator = null;
        Integer result = Integer.parseInt(inputs[0]);

        for (String input : inputs) {
            result = calculateFor(result, operator, input);
            operator = getFourPointOperation(input);
        }

        return result.toString();
    }

    private String[] splitInputString(String inputString) {

        if (isNull(inputString)) {
            throw new IllegalArgumentException("input string is null");
        }

        String[] inputs = inputString.split(" ");

        if (inputs.length == 0 || inputString.equals("")) {
            throw new IllegalArgumentException("input string is blank");
        }

        return inputs;

    }

    private FourPointOperation getFourPointOperation(String input) {

        if (isNumber(input)) {
            return null;
        }

        if (!isSymbolOfFourPointOperationOrNumber(input)) {
            throw new IllegalArgumentException("input is not symbol of four-point operation or Number");
        }

        return FourPointOperation.value(input);
    }

    private boolean isSymbolOfFourPointOperationOrNumber(String input) {
        return isFourPointOperator(input) || isNumber(input);
    }

    private boolean isFourPointOperator(String input) {
        return input.matches(FOUR_POINT_OPERATION_REG);
    }

    private boolean isNumber(String input) {
        return input.matches(NUMBER_REG);
    }

    public Integer calculateFor(Integer result, FourPointOperation operator, String input) {

        if (!isNull(operator)) {
            int operand = Integer.parseInt(input);
            return operator.calculate(result, operand);
        }

        return result;
    }


}
