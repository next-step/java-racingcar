package calculator;

import java.util.Deque;
import java.util.Queue;

import calculator.exception.InputFactorOverflowException;

public class CalculationFactor {
	private final Queue<OperatorFactor> operators;
	private final Deque<NumberFactor> numbers;

	public CalculationFactor(String expression) {
		this.operators = OperatorFactor.getOperatorFactors(expression);
		this.numbers = NumberFactor.getNumberFactors(expression);
		operatorNotGreaterNumberFactor(operators.size(), numbers.size());
	}

	public OperatorFactor getOperator() {
		return operators.remove();
	}

	public NumberFactor getNumber() {
		return numbers.removeFirst();
	}

	public void addBaseNumber(NumberFactor numberFactor) {
		numbers.addFirst(numberFactor);
	}

	public boolean isOperatorEmpty() {
		return operators.isEmpty();
	}

	private void operatorNotGreaterNumberFactor(int operators, int numbers) {
		if (operators >= numbers) {
			throw new InputFactorOverflowException();
		}
	}
}
