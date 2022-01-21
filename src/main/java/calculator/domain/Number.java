package calculator.domain;

public class Number {

    private final String sValue;

    public Number(String sNumber) {
        this.sValue = sNumber;
        validateNumber();
    }

    public int value() {
        return Integer.parseInt(sValue);
    }

    private void validateNumber() {
        try {
            Integer.parseInt(sValue);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("올바르지 않은 연산식입니다.");
        }
    }
}
