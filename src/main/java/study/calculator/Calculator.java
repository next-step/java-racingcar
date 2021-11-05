package study.calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
	public static final String SEPARATOR = " ";
	public static final String WRONG_FORMULA_MSG = "식이 잘못됐습니다.";

	public static MyNumber c(String s) {
		List<String> values = extractNumbers(s);
		Formula formula = setFormula(values);
		return formula.calc();
	}

	private static Formula setFormula(List<String> values) {
		MyNumber first = new MyNumber(values.get(0));
		String operator = values.get(1);
		MyNumber second = new MyNumber(values.get(2));

		return new Formula(first, operator, second);
	}

	private static List<String> extractNumbers(String s) {
		List<String> values = Arrays.asList(s.split(SEPARATOR));
		if (values.size() < 3) {
			throw new IllegalArgumentException(WRONG_FORMULA_MSG);
		}
		return values;
	}

}
