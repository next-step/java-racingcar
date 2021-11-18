package step2;

public class StringCalculator {

    public int calculate(Factor factor, int result) {
        Number first = factor.getNumbers(true, result);
        Number second = factor.getNumbers(false, result);

        Operator operator = factor.getOperator();

        result = calculate(first, operator, second);

        if(factor.isComplete()) return result;

        return calculate(factor, result);
    }

    public int calculate(Number number1, Operator operator, Number number2) {
        return number1.calculate(operator, number2);
    }
}
