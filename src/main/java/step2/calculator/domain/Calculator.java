package step2.calculator.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

	private Queue<Number> numbers;
	private Queue<Operator> operators;
	private Integer result;

	public int calculate(final String input) {
		validateInput(input);
		separate(input);
		if (numbers.isEmpty()) {
			return 0;
		}
		result = numbers.poll().getValue();
		calculate(numbers.poll(), operators.poll());

		return result;
	}

	private void validateInput(final String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력 값이 없습니다.");
		}
	}

	private void calculate(Number number, Operator operator) {
		if (number == null || operator == null) {
			return;
		}

		result = operator.operate(result, number.getValue());

		if (numbers.isEmpty() && operators.isEmpty()) {
			return;
		}

		calculate(numbers.poll(), operators.poll());
	}

	private void init() {
		numbers = new LinkedList<>();
		operators = new LinkedList<>();
	}

	void separate(final String source) {
		init();
		final String[] inputs = source.split(OperatorFactory.SPACE);
		for (String input : inputs) {
			store(input);
		}
		validateQueue();
	}

	private void store(final String input) {
		if (Number.isIntegerNumber(input)) {
			numbers.offer(new Number(Integer.parseInt(input)));
			return;
		}

		operators.offer(OperatorFactory.findOperator(input));
	}

	private void validateQueue() {
		String unfairMessage = "계산 대상 수와 사칙 연산의 짝이 안 맞습니다.";
		if (numbers.size() -1 != operators.size()) {
			throw new IllegalArgumentException(unfairMessage);
		}
	}

	Queue<Number> getNumbers() {
		return numbers;
	}

	Queue<Operator> getOperators() {
		return operators;
	}

}
