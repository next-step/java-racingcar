package calculator;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CalculationExpression {
	private final Deque<NumberFactor> numbers;
	private final Queue<OperatorFactor> operators;

	public CalculationExpression(String paramExpression) {
		List<NumberFactor> numberFactors = getNumberFactors(paramExpression);
		List<OperatorFactor> operatorFactors = getOperatorFactors(paramExpression);

		checkInputFactorOverflow(numberFactors.size(), operatorFactors.size());
		checkCalculationExpressionFormat(paramExpression);
		this.numbers = new LinkedList<>(numberFactors);
		this.operators = new LinkedList<>(operatorFactors);
	}

	private void checkCalculationExpressionFormat(String paramExpression) {
		if (!CalculationExpressionHelper.isCalculationExpression(paramExpression)) {
			throw new IllegalCalculationFormatException();
		}
	}

	private void checkInputFactorOverflow(int numbers, int operators) {
		if (operators >= numbers) {
			throw new InputFactorOverflowException();
		}
	}

	private List<OperatorFactor> getOperatorFactors(String paramExpression) {
		return Arrays.stream(paramExpression.split(" "))
			.filter(OperatorFactorHelper::isOperatorFactor)
			.map(OperatorFactor::new)
			.collect(Collectors.toList());
	}

	private List<NumberFactor> getNumberFactors(String paramExpression) {
		return Arrays.stream(paramExpression.split(" "))
			.filter(NumberFactorHelper::isNumeric)
			.map(NumberFactor::new)
			.collect(Collectors.toList());
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
