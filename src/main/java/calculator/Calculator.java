package calculator;

public class Calculator {
    public Double add(Double num1, Double num2) {
        return num1 + num2;
    }

    public Double sub(Double num1, Double num2) {
        return num1 - num2;
    }

    public Double mul(Double num1, Double num2) {
        return num1 * num2;
    }

    public Double div(Double num1, Double num2) throws ArithmeticException {
        Double divResult = num1 / num2;
        if (Double.isInfinite(divResult) || Double.isNaN(divResult)){
            throw new ArithmeticException("0 또는 0.0 으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }


}
