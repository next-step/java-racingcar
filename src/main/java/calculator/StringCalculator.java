package calculator;

public class StringCalculator {

    public int plus(int num,
                    int num2) {
        return num + num2;
    }

    public int minus(int num1,
                     int num2) {
        return num1 - num2;
    }

    public int divide(int num,
                      int num2) {
        validateDivision(num2);
        return num / num2;
    }

    private void validateDivision(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public int multiply(int num,
                        int num2) {
        return num * num2;
    }
}
