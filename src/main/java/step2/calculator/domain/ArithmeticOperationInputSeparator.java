package step2.calculator.domain;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticOperationInputSeparator {

	private final Queue<Number> numbers;
	private final Queue<Operator> operators;

	public ArithmeticOperationInputSeparator(final String input) {
		validateInput(input);
		this.numbers = new LinkedList<>();
		this.operators = new LinkedList<>();
		separate(input);
	}

	private String[] split(final String input) {
		validateInput(input);
		return input.split(OperatorFactory.INPUT_DELIMITER);
	}

	private void validateInput(final String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력 값이 없습니다.");
		}
	}

	private void separate(final String source) {
		final String[] inputs = split(source);
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

	public Queue<Number> getNumbers() {
		return numbers;
	}

	public Queue<Operator> getOperators() {
		return operators;
	}

}
