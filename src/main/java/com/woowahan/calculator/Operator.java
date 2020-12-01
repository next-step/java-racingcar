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
}
