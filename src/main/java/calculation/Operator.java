package calculation;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Operator {
	private static final String OPERATOR_PATTERN = "[-/*+]";
	private final String[] operator;

	public Operator(String[] formula) {
		this.operator = operatorsSeparation(formula);
	}

	private String[] operatorsSeparation(String[] formula) {
		return Arrays.stream(formula)
			.map(String::valueOf)
			.filter(i -> Pattern.matches(OPERATOR_PATTERN, i))
			.toArray(String[]::new);
	}

	public int size() {
		return operator.length;
	}

	public String value(int index) {
		return operator[index];
	}
}
