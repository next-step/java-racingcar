package calculator;

public interface CalculatorOperator {
	String PLUS = "+";
	String MINUS = "-";
	String MULTIPLY = "*";

	CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right);
}
