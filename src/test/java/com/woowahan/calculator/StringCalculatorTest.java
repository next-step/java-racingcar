package com.woowahan.calculator;

import static org.assertj.core.api.BDDAssertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

	@DisplayName("요구조건에 맞는 입력 연산")
	@ParameterizedTest
	@CsvSource(value = {
		"2 + 3 * 4 / 2=10",
		"2 + 3 * 4 + 5 - 3 * 2=44",
	}, delimiter = '=')
	void normalTest(String input, long expected) {

		//when
		long result = StringCalculator.calculate(input);

		//then
		then(result).isEqualTo(expected);

	}

}