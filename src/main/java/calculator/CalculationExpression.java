package calculator;

import calculator.exception.IllegalCalculationFormatException;
import calculator.exception.InputFactorOverflowException;
import calculator.helper.CalculationExpressionHelper;
import calculator.helper.NumberFactorHelper;
import calculator.helper.OperatorFactorHelper;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CalculationExpression {
	private final String separatorCalculationExpression = " ";
	private final Deque<NumberFactor> numbers;
	private final Queue<OperatorFactor> operators;

	public CalculationExpression(String inputExpression) {
		List<NumberFactor> numberFactors = getNumberFactors(inputExpression);
		List<OperatorFactor> operatorFactors = getOperatorFactors(inputExpression);

		operatorNotGreaterNumberFactor(operatorFactors.size(), numberFactors.size());
		checkCalculationExpressionFormat(inputExpression);
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

	private void checkCalculationExpressionFormat(String inputExpression) {
		if (!CalculationExpressionHelper.isCalculationExpression(inputExpression)) {
			throw new IllegalCalculationFormatException();
		}
	}

	private void operatorNotGreaterNumberFactor(int operators, int numbers) {
		if (operators >= numbers) {
			throw new InputFactorOverflowException();
		}
	}

	private List<OperatorFactor> getOperatorFactors(String inputExpression) {
		return Arrays.stream(inputExpression.split(separatorCalculationExpression))
			.filter(OperatorFactorHelper::isOperatorFactor)
			.map(OperatorFactor::new)
			.collect(Collectors.toList());
	}

	private List<NumberFactor> getNumberFactors(String inputExpression) {
		return Arrays.stream(inputExpression.split(separatorCalculationExpression))
			.filter(NumberFactorHelper::isNumeric)
			.map(NumberFactor::new)
			.collect(Collectors.toList());
	}

	private void executeNextCalculation() {
		NumberFactor baseNumber = numbers.pollFirst();
		NumberFactor targetNumber = numbers.pollFirst();
		OperatorFactor operator = operators.poll();
		if (operator != null) {
			numbers.addFirst(operator.valueOfFactor().calculate(baseNumber, targetNumber));
		}
	}
}
