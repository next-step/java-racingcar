package step2.calculator;


class StringAddCalculatorTokenException extends RuntimeException {

    public StringAddCalculatorTokenException(String message) {
        super(message);
    }
}


public class StringAddCalculatorToken {

    private final int value;

    public StringAddCalculatorToken(String value) {
        if (value.isEmpty()) {
            this.value = 0;
            return;
        }
        this.value = Integer.parseInt(value);
        validate();
    }

    public StringAddCalculatorToken(int number) {
        this.value = number;
        validate();
    }

    private void validate() {
        if (this.value < 0) {
            throw new StringAddCalculatorTokenException("Don't allow negative number");
        }
    }

    public int toInteger() {
        return this.value;
    }
}
