package study.calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
	private static final String SEPARATOR = " ";
	private static final String WRONG_FORMULA_MESSAGE = "식이 잘못됐습니다.";
	private static final int FORMULA_SIZE = 3;

	private Calculator() {
		throw new AssertionError();
	}

	public static MyNumber calculate(String inputFormula) {
		List<String> numbersAndOperators = splitFormula(inputFormula);
		return calculateFormula(numbersAndOperators);
	}

	private static MyNumber calculateFormula(List<String> numbersAndOperators) {
		MyNumber first = new MyNumber(numbersAndOperators.stream()
														.findFirst()
														.orElseThrow(IllegalArgumentException::new)
									);
		for (int i = 1; i < numbersAndOperators.size(); i+=2) {
			String operator = numbersAndOperators.get(i);
			MyNumber second = new MyNumber(numbersAndOperators.get(i+1));
			Formula formula = new Formula(first, operator, second);
			first = formula.calculate();
		}
		return first;
	}

	private static List<String> splitFormula(String InputFormula) {
		List<String> values = Arrays.asList(InputFormula.split(SEPARATOR));
		if (values.size() < FORMULA_SIZE) {
			throw new IllegalArgumentException(WRONG_FORMULA_MESSAGE);
		}
		return values;
	}

}
