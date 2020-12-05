package step2.calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

	private Queue<Integer> numbers;
	private Queue<Operator> operators;
	private Integer result;

	public int calculate(final String input) {
		separate(input);
		validate(input);
		result = numbers.poll();
		calculate(numbers.poll(), operators.poll());

		return result;
	}

	private void validate(final String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력 값이 없습니다.");
		}

		if (numbers.isEmpty()) {
			throw new IllegalArgumentException("입력된 숫자가 없습니다.");
		}

		if (operators.isEmpty()) {
			throw new IllegalArgumentException("입력된 사칙연산이 없습니다.");
		}
	}

	private void calculate(Integer number, Operator operator) {
		if (number == null || operator == null) {
			return;
		}

		result = operator.operate(result, number);

		if (numbers.isEmpty() || operators.isEmpty()) {
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
	}

	private void store(final String input) {
		if (OperatorSign.isSign(input)) {
			operators.offer(OperatorFactory.findOperator(input));
			return;
		}
		storeNumber(input);
	}

	private void storeNumber(final String input) {
		int number;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}

		numbers.offer(number);
	}

	Queue<Integer> getNumbers() {
		return numbers;
	}

	Queue<Operator> getOperators() {
		return operators;
	}

}
