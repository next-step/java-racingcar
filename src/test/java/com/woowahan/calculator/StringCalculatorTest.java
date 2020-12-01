package com.woowahan.calculator;

import static org.assertj.core.api.BDDAssertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

	@DisplayName("요구조건에 맞는 입력 연산")
	@ParameterizedTest
	@CsvSource(value = {
		"5 + 3 =8",
		"5 - 3 =2",
		"5 * 3 =15",
		"6 / 3 =2",
		"2 + 3 * 4 / 2=10",
		"2 + 3 * 4 + 5 - 3 * 2=44",
	}, delimiter = '=')
	void calculate(String value, long expected) {

		//when
		long result = StringCalculator.calculate(value);

		//then
		then(result).isEqualTo(expected);

	}

	@DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@NullAndEmptySource
	void calculateNullOrEmpty(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				StringCalculator.calculate(value);
			}).withMessageMatching(Validator.MSG_NULL_OR_EMPTY);

	}

	@DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"2 ! 3 @ 4 / 2", "3 ^ 3 ) 6"})
	void calculateNotOperator(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				StringCalculator.calculate(value);
			}).withMessageMatching(Validator.MSG_NOT_FOUND_OPERATOR);

	}

}