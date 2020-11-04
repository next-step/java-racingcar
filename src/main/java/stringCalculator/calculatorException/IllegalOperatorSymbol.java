package stringCalculator.calculatorException;

public class IllegalOperatorSymbol extends ArithmeticException {
    public IllegalOperatorSymbol() {
        super("허용되지 않는 연산자 입니다.");
    }
}
