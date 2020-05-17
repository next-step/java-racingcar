package calculator;

public class CalculatorSymbol {

    private static CalculatorSymbol calculatorSymbol = null;

    private CalculatorSymbol() {
    }

    public static CalculatorSymbol getInstance() {

        if (calculatorSymbol == null) {
            calculatorSymbol = new CalculatorSymbol();
        }
        return calculatorSymbol;
    }


    private int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    private int subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    private int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    private int division(int firstNum, int secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("분모가 0일수 없습니다.");
        }
        return firstNum / secondNum;
    }

    public int findTypeAndCalculator(int firstNum, int secondNum, String symbol) {
        switch (symbol) {
            case "+":
                return add(firstNum, secondNum);
            case "-":
                return subtract(firstNum, secondNum);
            case "*":
                return multiply(firstNum, secondNum);
            case "/":
                return division(firstNum, secondNum);
            default:
                throw new IllegalArgumentException("calculatorsymbol is error");
        }
    }

}
