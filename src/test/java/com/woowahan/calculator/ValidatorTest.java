package com.woowahan.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

	@DisplayName("validateNullOrEmpty 메서드는 전달 받은 파라미터의 값이 null 또는 empty일때 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@NullAndEmptySource
	public void validateNullOrEmpty(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Validator.validateNullOrEmpty(value);
			}).withMessageMatching(Validator.MSG_NULL_OR_EMPTY);

	}

	@DisplayName("validateTwoBlank 메서드는 전달받은 파라미터의 값에 빈문자열이 연속으로 2개 이상인 빈문자가 포함되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"   ", "  a   b  ", " a b c  d"})
	public void validateTwoBlank(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Validator.validateTwoBlank(value);
			}).withMessageMatching(Validator.MSG_TWO_BLANK);

	}

	@DisplayName("validateInput 메서드는 validateNullOrEmpty메서드와 validateTwoBlank메서드 기능을 포함한다.")
	@ParameterizedTest
	@ValueSource(strings = {"   ", "  a   b  ", " a b c  d"})
	@NullAndEmptySource
	public void validateInput(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Validator.validateInput(value);
			});

	}

	@DisplayName("validateNumber 메서드는 숫자가 아닌 문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"   ", "  a   b  ", " a b c  d"})
	@NullAndEmptySource
	public void validateNumber(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Validator.validateNumber(value);
			}).withMessageMatching(Validator.MSG_NOT_A_NUMBER);

	}

}