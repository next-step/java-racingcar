package calculaor;

public class Calculator {

    // 사칙연산 기능
    public int add(int number1, int number2) {
        return number1 + number2;
    }

    public int sub(int number1, int number2) {
        return number1 - number2;
    }

    public int mul(int number1, int number2) {
        return number1 * number2;
    }

    public int div(int number1, int number2) {
        try {
            int divValue = number1 / number2;
        } catch (ArithmeticException e) {
            System.out.println("0으로는 나눌 수 없습니다.");
        } return number1 / number2;
    }
}
