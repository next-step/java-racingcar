package calculator;

public class Calculator {

    public String calculate(String inputString) {

        String[] inputs = splitInputString(inputString);

        FourPointOperation operatorOrNumber = FourPointOperation.NUMBER;
        Integer result = Integer.parseInt(inputs[0]);

        for (String input : inputs) {
            Expression expression = new Expression(result, operatorOrNumber, input);
            result = calculateFor(expression);
            operatorOrNumber = getFourPointOperation(input);
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

        if (!isSymbolOfFourPointOperationOrNumber(input)) {
            throw new IllegalArgumentException("input is not symbol of four-point operation or Number");
        }

        if (input.equals("+")) {
            return FourPointOperation.PLUS;
        }
        if (input.equals("-")) {
            return FourPointOperation.MINUS;
        }

        if (input.equals("*")) {
            return FourPointOperation.TIMES;
        }

        if (input.equals("/")) {
            return FourPointOperation.DIVIDE;
        }

        return FourPointOperation.NUMBER;
    }

    private boolean isSymbolOfFourPointOperationOrNumber(String input) {
        return input.matches("[-*/+]") || input.matches("[0-9]+$");
    }

    public Integer calculateFor(Expression expression) {

        if (expression.getOperator() != FourPointOperation.NUMBER) {
            Integer operand = Integer.parseInt(expression.getY());
            return expression.getOperator().calculate(expression.getX(), operand);
        }

        return expression.getX();
    }


}
