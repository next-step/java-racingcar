package calculator;

public class Calculator {
    private String[] values;
    private Double result = 0.0;
    private int tempNumber = 0;

    private String SEPARATOR = " ";

    public Calculator(String input) {
        validate(input);
        this.values = splitValue(input);
        calculate();
    }

    private int calculate() {
        result = Double.parseDouble(values[0]);
        for (int i = 1; i < values.length; i++) {
            parseValue(i);
        }
        return 0;
    }

    private void parseValue(int i) {
        if (!isNumeric(values[i])) {
            tempNumber = Integer.parseInt(values[i + 1]);
            operatorDivision(values[i]);
        }
    }

    private void validate(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("input value is null");
        } else if ("".equals(input.trim())) {
            throw new IllegalArgumentException("input value is blank");
        }
    }

    private void operatorDivision(String operator) {
        switch (operator) {
            case "+":
                add();
                break;
            case "-":
                minus();
                break;
            case "*":
                multiplication();
                break;
            case "/":
                division();
                break;
            default:
                throw new IllegalArgumentException("input value is invalid operator");
        }
        resetTemp();
    }

    private void add() {
        this.result += tempNumber;
    }

    private void minus() {
        this.result -= tempNumber;
    }

    private void multiplication() {
        this.result *= tempNumber;
    }

    private void division() {
        this.result /= tempNumber;
    }

    private void resetTemp() {
        this.tempNumber = 0;
    }

    private String[] splitValue(String input) {
        String[] values = input.split(SEPARATOR);
        return values;
    }

    private boolean isNumeric(String value) {
        String regExp = "^[0-9]+";
        return value.matches(regExp);
    }

    public Double getResult() {
        return this.result;
    }

}
