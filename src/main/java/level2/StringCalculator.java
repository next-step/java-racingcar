package level2;

public class StringCalculator {

    public int calculate(Number number1, Operator operator, Number number2) {
        return number1.calculate(operator, number2);
    }

    public int calculate(Factor factor) {
        return 10;
    }
}
