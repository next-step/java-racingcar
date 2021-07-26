package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
	final String regex = " ";

	public int calculate(String calculationFormula) {
		if (calculationFormula == null || calculationFormula.length() == 0 ||  calculationFormula.equals(" ")) {
			throw new IllegalArgumentException();
		}

		String[] numberAndOperator = calculationFormula.split(regex);

		return executeArithmetic(numberAndOperator);
	}

	private int executeArithmetic(String[] numberAndOperator) {
		CalculatorNumber left = new CalculatorNumber(Integer.parseInt(numberAndOperator[0]));

		for(int i = 1; i < numberAndOperator.length; i += 2) {
			CalculatorOperator operator = CalculatorOperator.getCalculatorOperator(numberAndOperator[i]);
			CalculatorNumber right = new CalculatorNumber(Integer.parseInt(numberAndOperator[i+1]));
			left =  operator.operate(left, right);
		}

		return left.toInteger();
	}
}
