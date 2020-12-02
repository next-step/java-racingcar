package com.woowahan.calculator;

import java.util.List;

public class ParseResult {

	private List<Long> numbers;
	private List<Operator> operators;

	private ParseResult(List<Long> numbers, List<Operator> operators) {
		this.numbers = numbers;
		this.operators = operators;
	}

	public static ParseResult of(List<Long> numbers, List<Operator> operators) {
		return new ParseResult(numbers, operators);
	}

	public List<Long> getNumbers() {
		return numbers;
	}

	public List<Operator> getOperators() {
		return operators;
	}
}
