package calculator;

import calculator.exception.IllegalCalculationFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculationExpressionFactory extends CalculationFactory {
	private static final Pattern calculationExpressionFormatPattern = Pattern.compile("^\\d+(?:\\s[+-/*]\\s\\d+)+$");
	private static final String SEPARATOR_CALCULATION_EXPRESSION = " ";

	private String inputExpression;

	@Override
	public CalculationExpression calculationExpressionParser(String inputExpression) {
		this.inputExpression = inputExpression;
		checkCalculationExpressionFormat();
		return new CalculationExpression(getOperatorFactors(), getNumberFactors());
	}

	public List<OperatorFactor> getOperatorFactors() {
		return Arrays.stream(inputExpression.split(SEPARATOR_CALCULATION_EXPRESSION))
			.filter(OperatorFactor::validator)
			.map(OperatorFactor::new)
			.collect(Collectors.toList());
	}

	public List<NumberFactor> getNumberFactors() {
		return Arrays.stream(inputExpression.split(SEPARATOR_CALCULATION_EXPRESSION))
			.filter(NumberFactor::validator)
			.map(NumberFactor::new)
			.collect(Collectors.toList());
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
