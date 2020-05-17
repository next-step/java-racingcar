package step2;

public class Calculator {
    /**
     * 연산자에 맞게 left와 right를 계산한다.
     * 
     * @param operator : String, 연산자
     * @param left     : double, 좌항
     * @param right    : double, 우항
     * @return double, 계산 결과 반환
     */
    public double calculate(String operator, double left, double right) {
        return Operator.findOperatorBySymbol(operator).calculate(left, right);
    }
}
