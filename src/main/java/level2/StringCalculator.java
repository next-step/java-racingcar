package level2;

public class StringCalculator {

    public int calculate(Factor factor) {
        int numberIndex = 0;
        int calculatorIndex = 0;
        int result = 0;
        while(true) {
            result += calculate(factor.getNumbers(numberIndex),
                    factor.getOperator(calculatorIndex),
                    factor.getNumbers(numberIndex+1));

            numberIndex = numberIndex + 2;
            calculatorIndex = calculatorIndex + 1;

            if(factor.isComplete(numberIndex+calculatorIndex)) return result;
        }
    }

    public int calculate(Number number1, Operator operator, Number number2) {
        return number1.calculate(operator, number2);
    }
}
