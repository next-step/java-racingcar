package com.woowahan.calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	public static ParseResult parse(String input) {
		Validator.validateInput(input);
		String[] splits = input.trim().split(" ");
		return ParseResult.of(
			parseNumbers(splits),
			parseOperators(splits)
		);
	}

	private static List<Long> parseNumbers(String[] splits) {
		List<Long> numbers = new ArrayList<>();
		for (int i = 0; i < splits.length; i += 2) {
			numbers.add(Long.parseLong(splits[i]));
		}
		return numbers;
	}

	private static List<Operator> parseOperators(String[] splits) {
		List<Operator> operators = new ArrayList<>();
		for (int i = 1; i < splits.length; i += 2) {
			operators.add(Operator.getOperator(splits[i]));
		}
		return operators;
	}
}
