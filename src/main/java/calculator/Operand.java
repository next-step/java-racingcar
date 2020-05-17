package calculator;

public class Operand {
    private final Float number;

    public Operand(Float number) {
        this.number = number;
    }

    public static Operand valueOf(String number) {
        try {
            Float numberFloat = Float.valueOf(number);
            return new Operand(numberFloat);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(number + " cannot be converted to a number. Probably not a numeric string.");
        }
    }

    public Float getNumber() {
        return number;
    }

    public Operand calculate(Operator operator, Operand afterOperand) {
        Float calculatedValue = operator.calculate(number, afterOperand.getNumber());
        return new Operand(calculatedValue);
    }

}
