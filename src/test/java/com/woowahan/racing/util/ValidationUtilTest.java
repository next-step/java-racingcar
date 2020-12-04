package com.woowahan.racing.util;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidationUtilTest {

	@DisplayName("isNumber 메서드는 숫자로 변환이 가능한 문자열은 true를 반환하고 그렇지 않으면 false를 반환한다.")
	@ParameterizedTest
	@MethodSource("argIsNumber")
	void isNumber(String value, boolean expected) {
		boolean result = ValidationUtil.isNumber(value);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream argIsNumber() {
		return Stream.of(
			Arguments.of("0", true),
			Arguments.of("a", false),
			Arguments.of("", false),
			Arguments.of(null, false),
			Arguments.of("-5", true),
			Arguments.of("-35", true),
			Arguments.of("-3A5", false)
		);
	}

	@DisplayName("isPositve 메서드는 숫자로된 문자 중 0보다 큰 문자를 전달 받으면 true를 반환하고 작은 문자는 false를 반환한다.")
	@ParameterizedTest
	@MethodSource("argisPositve")
	void isPositve(String value, boolean expected) {
		boolean result = ValidationUtil.isPositve(value);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream argisPositve() {
		return Stream.of(
			Arguments.of("0", false),
			Arguments.of("1", true),
			Arguments.of("-1", false),
			Arguments.of("-10", false),
			Arguments.of("10", true)
		);
	}

	@DisplayName("validate 메서드는 isNumber 메서드와 isPositve를 동시에 만족해야만 true를 반환하고 나머지는 false다")
	@ParameterizedTest
	@MethodSource("argValidate")
	void validate(String value, boolean expected) {
		boolean result = ValidationUtil.validate(value);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream argValidate() {
		return Stream.of(
			Arguments.of("0", false),
			Arguments.of("1", true),
			Arguments.of("5", true),
			Arguments.of("a", false),
			Arguments.of("", false),
			Arguments.of(null, false),
			Arguments.of("-1", false),
			Arguments.of("-10", false),
			Arguments.of("-3A5", false)
		);
	}
}