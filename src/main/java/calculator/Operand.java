package calculator;

public class Operand {
    private final Float number;

    public Operand(Float number) {
        this.number = number;
    }

    public static Operand valueOf(String number) {
        Float numberFloat = Float.valueOf(number);
        return new Operand(numberFloat);
    }

    public Float getNumber() {
        return number;
    }

    public Operand calculate(Operator operator, Operand afterOperand) {
        Float calculatedValue = operator.calculate(number, afterOperand.getNumber());
        return new Operand(calculatedValue);
    }

    public static boolean isOperand(String number) {
        try {
            Float.valueOf(number);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
