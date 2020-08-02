package calculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Calculator {

	private final LinkedList<Integer> numberGroup = new LinkedList<>();
	private final LinkedList<OperatorType> operatorTypeGroup = new LinkedList<>();
	private int result = 0;

	public int calculate(final String inputValues) {
		if(inputValues.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}

		initialize(inputValues);

		int index = 0;
		for(final OperatorType type : operatorTypeGroup) {
			result = type.getOperator().operate(index > 0 ?
					result : numberGroup.removeFirst(), numberGroup.removeFirst());
			index++;
		}

		return result;
	}

	private void initialize(final String inputValues) {
		final StringTokenizer st = new StringTokenizer(inputValues);

		while (st.hasMoreTokens()) {
			final String value = st.nextToken();

			if (isDigit(value)) {
				numberGroup.add(Integer.valueOf(value));
			} else {
				operatorTypeGroup.add(OperatorType.getOperatorTypeByCode(value));
			}
		}
	}

	private boolean isDigit(final String s) {
		return Objects.nonNull(s) && !s.isEmpty() && s.matches("-?\\d+(\\.\\d+)?");
	}
}
