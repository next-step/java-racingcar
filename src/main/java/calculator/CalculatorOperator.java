package calculator;

public interface CalculatorOperator {
	String PLUS = "+";

	CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right);
}
