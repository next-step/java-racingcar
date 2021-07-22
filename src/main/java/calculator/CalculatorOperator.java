package calculator;

public interface CalculatorOperator {
	String PLUS = "+";
	String MINUS = "-";
	String MULTIPLY = "*";
	String DIVIDE = "/";

	CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right);
}
