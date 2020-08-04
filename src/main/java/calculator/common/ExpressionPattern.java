package calculator.common;

import java.util.regex.Pattern;

public enum ExpressionPattern {
	EXPRESSION_PATTERN("[0-9](\\s(\\+|\\-|\\*|\\/)\\s[0-9])+"),
	OPERATION_PATTERN("[\\+|\\-|\\*|\\/]");

	private String pattern;

	ExpressionPattern(String pattern) {
		this.pattern = pattern;
	}

	public boolean isMatch(String value) {
		return Pattern.matches(pattern, value);
	}
}
