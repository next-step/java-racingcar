package calculator;

public final class CalculatorSymbol {

    private static CalculatorSymbol calculatorSymbol = null;

    private CalculatorSymbol() {
    }

    public static CalculatorSymbol getInstance() {

        if (calculatorSymbol == null) {
            calculatorSymbol = new CalculatorSymbol();
        }
        return calculatorSymbol;
    }

    public int findTypeAndCalculator(int firstNum, int secondNum, String symbol) {
        switch (symbol) {
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "*":
                return firstNum * secondNum;
            case "/":
                if (secondNum == 0) {
                    throw new ArithmeticException("분모가 0일수 없습니다.");
                }
                return firstNum / secondNum;
            default:
                throw new IllegalArgumentException("calculatorSymbol is error");
        }
    }

}
