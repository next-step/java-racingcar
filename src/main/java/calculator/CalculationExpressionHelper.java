package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationExpressionHelper {
	public static final Pattern calculationExpressionPattern = Pattern.compile("^\\d+(?:\\s[+-/*]\\s\\d+)+$");

	public static boolean isCalculationExpression(String expression) {
		Matcher calculationExpressionMatcher = calculationExpressionPattern.matcher(expression);
		return calculationExpressionMatcher.find();
	}

}
