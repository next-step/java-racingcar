package step2;

import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
	private static final Pattern BLANK_PATTERN = Pattern.compile("^\\s*$");

	private static List<Calculator> calculators = new ArrayList<>();
	static {
		calculators.add(new AdditionCalculator());
		calculators.add(new SubtractionCalculator());
		calculators.add(new MultiplicationCalculator());
		calculators.add(new DivisionCalculator());
	}

	private static boolean isNumberPattern(String str) {
		return ONLY_NUMBER_PATTERN.matcher(str).matches();
	}

	private static boolean isBlankPattern(String str) {
		return BLANK_PATTERN.matcher(str).matches();
	}

	public String getResult(String str) {
		if(this.isEmpty(str)) {
			throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자");
		}

		String[] values = str.split(" ");
		Stack<String> expression = new Stack<>();
		for(String value : values) {
			expression.push(value);
			stackCalculatedValue(expression, value);
		}
		return expression.pop();

	}

	public Stack<String> stackCalculatedValue(Stack<String> expression, String value) {
		if(isNumberPattern(value) && expression.size() == 3) {
			expression.push(this.calculate(Integer.parseInt(expression.pop()), expression.pop(), Integer.parseInt(expression.pop())));
		}
		return expression;
	}

	public String calculate(int num2, String op, int num1) {
		Optional<Calculator> maybeCalculator = calculators.stream().filter(o -> o.isValidOperator(op)).findFirst();
		Calculator calculator = maybeCalculator.orElseThrow(IllegalArgumentException::new);
		return String.valueOf(calculator.calculate(num1, num2));
	}

	public boolean isEmpty(String str) {
		return null == str || str.length() == 0 || isBlankPattern(str);
	}

}
