package step2;

/**
 * step2.Calculator.calculate() 에 입려되는 expression 유효성을 판단하는 역할을 합니다.
 */
public interface ExpressionValidator {
    void validate(String expression) throws InvalidExpressionException;
}

