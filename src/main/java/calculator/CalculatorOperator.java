package calculator;

public interface CalculatorOperator {
	String PLUS = "+";
	String MINUS = "-";

	CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right);
}
