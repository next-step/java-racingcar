package step2;

public class Calculator {

    private Operation operation;

    public double calculate(double result, String input) {
        if (isEmptyOrNull(input)) throw new IllegalArgumentException();

        if (!isNumeric(input)) {
            saveOperation(input);
            return result;
        }
        if (this.operation != null) {
            return operation.calculate(result, Integer.parseInt(input));
        }

        return Integer.parseInt(input);
    }

    private boolean isEmptyOrNull(String input) {
        return input == null || input.trim().isEmpty();
    }

    boolean isNumeric(String input) {
        boolean isNumeric = true;
        for (char c : input.toCharArray())
            isNumeric = Character.isDigit(c) ? true : false;
        return isNumeric;
    }

    private void saveOperation(String input) {
        this.operation = Operation.getOperation(input);
    }

}
