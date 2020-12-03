package step2;

public class Calculator {

    private double val;
    private Operation operation;

    public double displayResult(String input) {
        if (input == null || input.trim().isEmpty()) throw new IllegalArgumentException();
        for (String s : input.split(" ")) calculate(s);
        return this.val;
    }

    private void calculate(String input) {
        if (!isNumeric(input)) {
            saveOperation(input);
            return;
        }
        if (this.operation != null) {
            operate(Integer.parseInt(input));
            return;
        }
        initVal(Integer.parseInt(input));
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

    private void operate(double input) {
        this.val = operation.calculate(this.val, input);
    }

    private void initVal(double input) {
        this.val = input;
    }
}
