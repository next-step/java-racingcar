public class Calculator {
    public Long add(Long firstNum, Long secondNum) {
        return firstNum + secondNum;
    }

    public Long subtract(Long firstNum, Long secondNum) {
        return firstNum - secondNum;
    }

    public Long multiply(Long firstNum, Long secondNum) {
        return firstNum * secondNum;
    }

    public Long division(Long firstNum, Long secondNum) {
        if (firstNum == 0) {
            throw new ArithmeticException("분모가 0일수 없습니다.");
        }
        return firstNum / secondNum;
    }

}
