package com.woowahan.calculator;

import java.util.concurrent.atomic.AtomicInteger;

public class StringCalculator {

	public static Long calculate(String numbers) {
		ParseResult parseResult = Parser.parse(numbers);
		AtomicInteger index = new AtomicInteger();
		return parseResult.getNumbers()
			.stream()
			.reduce((a, b) -> parseResult.getOperators().get(index.getAndIncrement()).getOperator().applyAsLong(a, b))
			.orElseThrow(() -> new NullPointerException(Validator.MSG_RETURN_NULL));
	}
}
