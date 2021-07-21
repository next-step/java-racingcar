package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	private static final String FORMULA_SEPARATOR = " ";
	private final List<Integer> operands = new ArrayList<>();
	private final List<String> signs = new ArrayList<>();

	public int calculate(String formula) {
		if (isBlank(formula)) {
			throw new IllegalArgumentException();
		}

		String[] strings = formula.split(FORMULA_SEPARATOR);
		for (int i = 0; i < strings.length; i++) {
			addElement(i, strings[i]);
		}

		return sum();
	}

	private boolean isBlank(String formula) {
		return formula == null || formula.isEmpty() || formula.trim().isEmpty();
	}

	private void addElement(int index, String element) {
		if (index % 2 == 0) {
			operands.add(Integer.parseInt(element));
			return;
		}
		signs.add(element);
	}

	private int sum() {
		int result = operands.remove(0);
		for (int i = 0; i < signs.size(); i++) {
			String sign = signs.get(i);
			Integer rightOperand = operands.get(i);
			result = Operator.from(sign).calculate(result, rightOperand);
		}

		return result;
	}

}
