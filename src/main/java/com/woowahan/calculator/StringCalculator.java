package com.woowahan.calculator;

import java.util.concurrent.atomic.AtomicInteger;

public class StringCalculator {

	public static Long calculate(String numbers) {
		ParseResult parseResult = Parser.parse(numbers);
		throw new RuntimeException("파싱 결과 값을 가지고 리듀스 형태로 계산한다.");
	}
}
