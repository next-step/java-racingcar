package com.woowahan.calculator;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;

public enum Operator {

	PLUS("+", (a, b) -> a + b),
	MINUS("-", (a, b) -> a - b),
	MULTIPLE("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> a / b);

	private final String keyword;
	private final LongBinaryOperator operator;

	Operator(String keyword, LongBinaryOperator operator) {
		this.keyword = keyword;
		this.operator = operator;
	}

	public static Operator getOperator(String op) {
		return Arrays.stream(Operator.values())
			.filter(operator -> op.equals(operator.getKeyword()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Validator.MSG_NOT_FOUND_OPERATOR));
	}

	public String getKeyword() {
		return keyword;
	}

	public LongBinaryOperator getOperator() {
		return operator;
	}
}
