package step2.operation;

public class DivisionOperation implements ArithmeticOperation {
    @Override
    public Integer apply(Integer value1, Integer value2) {
        checkDivisor(value2);
        checkRemainder(value1, value2);
        return value1 / value2;
    }

    private void checkDivisor(Integer divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
    }

    private void checkRemainder(Integer value1, Integer value2) {
        int remainder = value1 % value2;
        if (remainder != 0) {
            throw new ArithmeticException("나눗셈은 결괏값이 정수로 떨어지는 값이어야 합니다");
        }
    }
}
