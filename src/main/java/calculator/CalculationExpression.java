package calculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CalculationExpression {
	private final Deque<NumberFactor> numbers;
	private final Queue<OperatorFactor> operators;

	public CalculationExpression(List<NumberFactor> numbers, List<OperatorFactor> operators) {
		this.numbers = new LinkedList<>(numbers);
		this.operators = new LinkedList<>(operators);
	}

	public void executeAll() {
		if (operators.isEmpty()) {
			return;
		}
		executeNextCalculation();
		executeAll();
	}

	private void executeNextCalculation() {
		NumberFactor baseNumber = numbers.pollFirst();
		NumberFactor targetNumber = numbers.pollFirst();
		OperatorFactor operator = operators.poll();
		if (operator != null) {
			numbers.addFirst(operator.valueOfFactor().calculate(baseNumber, targetNumber));
		}
	}

	public NumberFactor getResult() {
		return numbers.pollFirst();
	}

}
