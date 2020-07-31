package calculator.common;

import java.util.regex.Pattern;

public enum ExpressionPattern {
	EXP("[0-9](\\s(\\+|\\-|\\*|\\/)\\s[0-9])+", "문자열 계산식 패턴"),
	OPR("[\\+|\\-|\\*|\\/]", "연산자 패턴");

	private String pattern;
	private String description;

	ExpressionPattern(String pattern, String description) {
		this.pattern = pattern;
		this.description = description;
	}

	public boolean isMatch(String value) {
		return Pattern.matches(pattern, value);
	}
}
