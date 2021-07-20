package stringcalculator;

public class Calculator {

	public int calculate(String formula) {
		if (isBlank(formula)) {
			throw new IllegalArgumentException();
		}

		return 0;
	}

	private boolean isBlank(String formula) {
		return formula == null || formula.isEmpty() || formula.trim().isEmpty();
	}

}
