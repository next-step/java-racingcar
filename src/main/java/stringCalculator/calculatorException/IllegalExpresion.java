package stringCalculator.calculatorException;

public class IllegalExpresion extends ArithmeticException {
    public IllegalExpresion() {
        super("정상적인 형태의 표현식이 아닙니다.");
    }
}
