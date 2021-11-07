package study.calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
	private static final String SEPARATOR = " ";
	private static final String WRONG_FORMULA_MESSAGE = "식이 잘못됐습니다.";
	private static final int INDEX_FIRST_NUMBER = 0;
	private static final int INDEX_OPERATOR = 1;
	private static final int INDEX_SECOND_NUMBER = 2;
	private static final int FORMULA_SIZE = 3;

	private Calculator(){
		throw new AssertionError();
	}

	public static MyNumber calculate(String s) {
		List<String> values = extractNumbers(s);
		Formula formula = setFormula(values);
		return formula.calc();
	}

	private static Formula setFormula(List<String> values) {
		MyNumber first = new MyNumber(values.get(INDEX_FIRST_NUMBER));
		String operator = values.get(INDEX_OPERATOR);
		MyNumber second = new MyNumber(values.get(INDEX_SECOND_NUMBER));

		return new Formula(first, operator, second);
	}

	private static List<String> extractNumbers(String InputFormula) {
		List<String> values = Arrays.asList(InputFormula.split(SEPARATOR));
		if (values.size() < FORMULA_SIZE) {
			throw new IllegalArgumentException(WRONG_FORMULA_MESSAGE);
		}
		return values;
	}

}
