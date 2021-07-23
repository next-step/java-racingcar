package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
	final String regex = " ";
	Queue<CalculatorOperator> operators;
	Queue<CalculatorNumber> numbers;

	Calculator() {
		operators = new LinkedList<>();
		numbers = new LinkedList<>();
	}

	private void classifyNumberAndOperator(String item) {
		if(isCalculatorOperator(item)) {
			operators.add(CalculatorOperatorFactory.create(item));
			return;
		}

		try {
			numbers.add(new CalculatorNumber(toInt(item)));
		} catch(Error error) {
			throw new IllegalArgumentException();
		}
	}

	private int innerCalculate() {
		CalculatorNumber left = numbers.poll();
		CalculatorNumber right = numbers.poll();
		while(right != null) {
			CalculatorOperator operator = operators.poll();
			left = operator.operate(left, right);
			right = numbers.poll();
		}
		return left.toInteger();
	}

	private int toInt(String value) {
		return Integer.parseInt(value);
	}

	private boolean isCalculatorOperator(String item) {
		if(item.equals(CalculatorOperator.PLUS) ||
			item.equals(CalculatorOperator.DIVIDE) ||
			item.equals(CalculatorOperator.MINUS) ||
			item.equals(CalculatorOperator.MULTIPLY)) {
			return true;
		}
		return false;
	}

	public int calculate(String calculationFormula) {
		if (calculationFormula == null || calculationFormula.length() == 0 ||  calculationFormula.equals(" ")) {
			throw new IllegalArgumentException();
		}

		String[] numberAndOperator = calculationFormula.split(regex);

		for (String item : numberAndOperator) {
			classifyNumberAndOperator(item);
		}

		return innerCalculate();
	}
}
