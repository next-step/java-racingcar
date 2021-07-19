package calculator.expression;


public class Number extends Expression {

    private Number(String numberString) {
        this.operand = Integer.parseInt(numberString);
    }

    public static Number of(String numberString) {
        return new Number(numberString);
    }

    @Override
    public int calculate() {
        return operand;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Number that = (Number) obj;
        return this.operand == that.operand;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
