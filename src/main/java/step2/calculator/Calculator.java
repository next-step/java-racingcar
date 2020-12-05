package step2.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	private List<Integer> numbers = new ArrayList<>();
	private List<Operator> operators = new ArrayList<>();

	public void separate(final String source) {
		final String[] inputs = source.split(OperatorFactory.SPACE);
		for (String input : inputs) {
			store(input);
		}
	}

	private void store(final String input) {
		if (OperatorSign.isSign(input)) {
			operators.add(OperatorFactory.findOperator(input));
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

		numbers.add(number);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public List<Operator> getOperators() {
		return operators;
	}
}
