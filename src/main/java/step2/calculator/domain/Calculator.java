package step2.calculator.domain;

import java.util.Queue;

public class Calculator {

	private Integer result;

	public int calculate(final Queue<Number> numbers, final Queue<Operator> operators) {
		if (numbers.isEmpty()) {
			return 0;
		}

		if (result == null) {
			result = numbers.poll().getValue();
		}

		Number number = numbers.poll();
		Operator operator = operators.poll();

		if (number == null || operator == null) {
			return result;
		}

		result = operator.operate(result, number.getValue());

		calculate(numbers, operators);

		return result;
	}

}
