package stringCalculator;

public class Calculator {

    public int addition(int first, int second) {
        return first + second;
    }

    public int substract(int first, int second) {
        return first - second;
    }

    public int multiplication(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        if(second == 0) throw new ArithmeticException("0으로는 나눌 수 없습니다");
        return first / second;
    }

}
