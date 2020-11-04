package calculator;

public class Calculator {

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

        if (inputString == null) {
            throw new IllegalArgumentException("input string is null");
        }

        String[] inputs = inputString.split(" ");

        if (inputs.length == 0 || inputString.equals("")) {
            throw new IllegalArgumentException("input string is blank");
        }

        return inputs;

    }

    private FourPointOperation getFourPointOperation(String input) {

        if (input.matches("[0-9]+$")) {
            return null;
        }

        if (!isSymbolOfFourPointOperationOrNumber(input)) {
            throw new IllegalArgumentException("input is not symbol of four-point operation or Number");
        }

        return FourPointOperation.value(input);
    }

    private boolean isSymbolOfFourPointOperationOrNumber(String input) {
        return input.matches("[-*/+]") || input.matches("[0-9]+$");
    }

    public Integer calculateFor(Integer result, FourPointOperation operator, String input) {

        if (operator != null) {
            Integer operand = Integer.parseInt(input);
            return operator.calculate(result, operand);
        }

        return result;
    }


}
