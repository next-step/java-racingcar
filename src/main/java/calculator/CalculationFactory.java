package calculator;

public interface CalculationFactory {
	Calculation calculationExpressionParser(String inputExpression);
}
