package calculator;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class NumberFactor {
	private final int value;

	public NumberFactor(String value) {
		this.value = Integer.parseInt(value);
	}

	public NumberFactor(int value) {
		this.value = value;
	}

	public Integer valueOfFactor() {
		return this.value;
	}

	public String valueOf() {
		return String.valueOf(value);
	}

	public static NumberFactor createFactor(int value) {
		return new NumberFactor(value);
	}

	public static Deque<NumberFactor> getNumberFactors(String expression) {
		return Arrays.stream(expression.split(CalculationExpressionFactory.SEPARATOR_CALCULATION_EXPRESSION))
			.filter(NumberFactor::validator)
			.map(NumberFactor::new)
			.collect(Collectors.toCollection(LinkedList::new));
	}

	private static boolean validator(String value) {
		try {
			Double.parseDouble(value);
		} catch (Exception isNotNumericException) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + valueOfFactor().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof NumberFactor)) {
			return false;
		}

		return this.valueOfFactor().equals(((NumberFactor) obj).valueOfFactor());
	}
}
