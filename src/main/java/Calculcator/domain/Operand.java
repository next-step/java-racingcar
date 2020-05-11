package Calculcator.domain;

public class Operand {
    private final double value;

    public Operand(double value) {
        this.value = value;
    }

    public Operand(String value) {
        validateNullOrEmpty(value);
        try {
            this.value = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 피연산자가 아닙니다. - " + value);
        }
    }

    public double getValue() {
        return value;
    }

    private void validateNullOrEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Null 또는 공백 문자는 피연산자가 될 수 없습니다.");
        }
    }
}
