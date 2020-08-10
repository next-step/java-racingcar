package step2;

import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
	private static final Pattern BLANK_PATTERN = Pattern.compile("^\\s*$");
	private static final String SEPARATOR = " ";

	private static boolean isNumberPattern(String term) {
		return ONLY_NUMBER_PATTERN.matcher(term).matches();
	}

	private static boolean isBlankPattern(String term) {
		return BLANK_PATTERN.matcher(term).matches();
	}

	public String getResult(String str) {
		if (!this.isPossibleCalculate(str)) {
			throw new IllegalArgumentException("계산할 수 없는 문자열");
		}

		String[] values = str.split(SEPARATOR);
		Stack<String> expression = new Stack<>();
		for(String value : values) {
			expression.push(value);
			stackCalculatedValue(expression, value);
		}
		return expression.pop();

	}

	private void stackCalculatedValue(Stack<String> expression, String value) {
		if(isNumberPattern(value) && expression.size() == 3) {
			expression.push(this.calculate(Integer.parseInt(expression.pop()), expression.pop(), Integer.parseInt(expression.pop())));
		}
		//return expression;
	}

	public String calculate(int num2, String op, int num1) {
		Operator operator = Operator.of(op);
		return operator.calculate(num1, num2);
	}

	private boolean isPossibleCalculate(String str) {
		return !isEmpty(str) && isLengthOver3(str) && isValidExpression(str.split(SEPARATOR));

	}

	private boolean isEmpty(String str) {
		return null == str || str.length() == 0 || isBlankPattern(str);
	}

	private boolean isLengthOver3(String str) {
		return str.length() >= 3;
	}

	private boolean isValidExpression(String[] strings) {
		return ONLY_NUMBER_PATTERN.matcher(strings[0]).matches() && ONLY_NUMBER_PATTERN.matcher(strings[strings.length-1]).matches();
	}

}
