package calculator.expression;


import calculator.utils.StringUtils;

public class Number extends Expression {

    private Number(String numberString) {
        validate(numberString);
        this.operand = Integer.parseInt(numberString);
    }

    private void validate(String numberString) {
        if (StringUtils.isEmpty(numberString)) {
            throw new IllegalArgumentException("Input number string is null or empty");
        }

        if (!StringUtils.isNumeric(numberString)) {
            throw new IllegalArgumentException("Input number string is not number");
        }
    }

    public static Number of(String numberString) {
        return new Number(numberString);
    }

    @Override
    public int calculate() {
        return operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return this.operand == that.operand;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
