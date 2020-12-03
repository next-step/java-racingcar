package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.exception.IllegalCalculationFormatException;

public class CalculationExpressionFactory implements CalculationFactory {
	public static final String SEPARATOR_CALCULATION_EXPRESSION = " ";
	private static final Pattern calculationExpressionFormatPattern = Pattern.compile("^\\d+(?:\\s[+-/*]\\s\\d+)+$");

	private String inputExpression;

	@Override
	public Calculation calculationExpressionParser(String inputExpression) {
		this.inputExpression = inputExpression;
		checkCalculationExpressionFormat();
		CalculationFactor calculationFactor = new CalculationFactor(inputExpression);
		return new CalculationExpression(calculationFactor);
	}

	private void checkCalculationExpressionFormat() {
		if (!isCalculationExpression()) {
			throw new IllegalCalculationFormatException();
		}
	}

	private boolean isCalculationExpression() {
		Matcher calculationExpressionMatcher = calculationExpressionFormatPattern.matcher(inputExpression);
		return calculationExpressionMatcher.find();
	}
}
