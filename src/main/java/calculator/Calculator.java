package calculator;

import java.util.*;

public class Calculator {

	private int convertInteger(final String s) {
		if (Objects.isNull(s) || s.isEmpty() || !s.matches("-?\\d+(\\.\\d+)?")) {
			throw new IllegalArgumentException("숫자가 잘못되었습니다.");
		}
		return Integer.parseInt(s);
	}

	private boolean validateCalculator(final String inputExpression) {
		return Objects.isNull(inputExpression) || inputExpression.trim().isEmpty();
	}

	public int calculate(final String inputExpression) {
		if (validateCalculator(inputExpression)) {
			throw new IllegalArgumentException();
		}

		final List<String> inputGroup = Arrays.asList(inputExpression.split(" "));
		int result = convertInteger(inputGroup.get(0));

		for (int i = 1; i < inputGroup.size(); i += 2) {
			result = OperatorType.getOperatorTypeByCode(inputGroup.get(i))
					.calculate(result, convertInteger(inputGroup.get(i + 1)));
		}

		return result;
	}
}
