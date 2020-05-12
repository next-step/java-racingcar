package calculator;

public class CalculatorSymbol {
    public int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public int subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    public int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    public int division(int firstNum, int secondNum) {
        if (firstNum == 0) {
            throw new ArithmeticException("분모가 0일수 없습니다.");
        }
        return firstNum / secondNum;
    }

}
