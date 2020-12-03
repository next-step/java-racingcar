package calculator;

public abstract class CalculationFactory {
	protected abstract CalculationExpression calculationExpressionParser(String inputExpression);
}
