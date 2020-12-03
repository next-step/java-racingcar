package calculator;

import calculator.exception.InputFactorOverflowException;

import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;

public class CalculationExpression {
	private final Deque<NumberFactor> numbers;
	private final Queue<OperatorFactor> operators;

	public CalculationExpression(List<OperatorFactor> operatorFactors, List<NumberFactor> numberFactors) {
		operatorNotGreaterNumberFactor(operatorFactors.size(), numberFactors.size());
		this.numbers = new LinkedList<>(numberFactors);
		this.operators = new LinkedList<>(operatorFactors);
	}

	public void executeAll() {
		if (operators.isEmpty()) {
			return;
		}
		executeNextCalculation();
		executeAll();
	}

	public NumberFactor getResult() {
		return numbers.pollFirst();
	}

	private void operatorNotGreaterNumberFactor(int operators, int numbers) {
		if (operators >= numbers) {
			throw new InputFactorOverflowException();
		}
	}

	private void executeNextCalculation() {
		NumberFactor baseNumber = numbers.removeFirst();
		NumberFactor targetNumber = numbers.removeFirst();
		OperatorFactor operator = operators.remove();
		numbers.addFirst(operator.valueOfFactor().calculate(baseNumber, targetNumber));
	}
}
