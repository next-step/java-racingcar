package com.woowahan.racing.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
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

	@DisplayName("validateCarName메서드는 전달된 문자열이 문자열이 null or empty이거나 5자를 초과하면 true를 반환한다.")
	@ParameterizedTest
	@MethodSource("argValidateCarName")
	void validateCarName(String value, boolean expected) {

		boolean result = ValidationUtil.validateCarName(value);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream argValidateCarName() {
		return Stream.of(
			Arguments.of("abcde", true),
			Arguments.of("가나다라마", true),
			Arguments.of("abc", true),
			Arguments.of("가나다라마바", false),
			Arguments.of("abcdefgh", false),
			Arguments.of("", false),
			Arguments.of(null, false)
		);
	}

	@DisplayName("allValidateName메서드에 전달된 파라미터 리스트 값중에 하나라도 문자열이 null or empty이거나 5자를 초과하면 true를 반환한다.")
	@ParameterizedTest
	@MethodSource("argAllValidateName")
	void allValidateName(List<String> value, boolean expected) {

		boolean result = ValidationUtil.allValidateName(value);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream argAllValidateName() {
		return Stream.of(
			Arguments.of(Arrays.asList("a", "ab", "abcde"), true),
			Arguments.of(Arrays.asList("a", "ab", "abcdef"), false),
			Arguments.of(Arrays.asList("", "ab", "abcde"), false),
			Arguments.of(Arrays.asList(null, "ab", "abcde"), false),
			Arguments.of(Arrays.asList("가나다"), true),
			Arguments.of(Arrays.asList("가나다라마", "abcde"), true)
		);
	}

	@DisplayName("isNullOrEmpty 메서드는 전달된 문자열이 null or empty인경우 true를 반환한다. 아닌 경우 false를 반환한다.")
	@ParameterizedTest
	@MethodSource("argIsNullOrEmpty")
	void isNullOrEmpty(String value, boolean expected) {

		boolean result = ValidationUtil.isNullOrEmpty(value);

		assertThat(result).isEqualTo(expected);
	}

	public static Stream argIsNullOrEmpty() {
		return Stream.of(
			Arguments.of(null, true),
			Arguments.of("", true),
			Arguments.of("abc", false)
		);
	}
}