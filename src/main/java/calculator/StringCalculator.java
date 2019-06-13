package calculator;

public class StringCalculator {

    int plus(int num,
             int num2) {
        return num + num2;
    }

    int minus(int num1,
              int num2) {
        return num1 - num2;
    }

    int divide(int num,
               int num2) {
        validateDivision(num2);
        return num / num2;
    }

    private void validateDivision(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    int multiply(int num,
                 int num2) {
        return num * num2;
    }

    public int calculate(int num,
                          char symbol,
                          int num2) {
        switch (symbol){
            case '+' : return plus(num, num2);
            case '-' : return minus(num, num2);
            case '/' : return divide(num, num2);
            case '*' : return multiply(num, num2);
            default: throw new IllegalArgumentException(symbol + " 부호는 연산이 불가합니다.");
        }
    }
}
