package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputResultTest {

	@DisplayName("of 메서드는 InputResult 인스턴스를 반환한다.")
	@ParameterizedTest
	@MethodSource("argOf")
	void of(List<String> carNames, int tryCount) {

		InputResult result = InputResult.of(carNames, tryCount);
		assertThat(result).isInstanceOf(InputResult.class);
	}

	public static Stream argOf() {
		return Stream.of(
			Arguments.of(Arrays.asList("abc"), 3),
			Arguments.of(Arrays.asList("abc", "가나다"), 5),
			Arguments.of(Arrays.asList("abc", "가나다", "xyz"), 7)
		);
	}

	@DisplayName("of 메서드는 carNames인자가 null 또는 사이즈가 0이거나 tryCount인자가 0과 같거나 작은 값을 전달 받는 경우 IllegalArgumentException을 발생시킨다.")
	@ParameterizedTest
	@MethodSource("argOfThrow")
	void ofThrow(List<String> carNames, int tryCount) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				InputResult.of(carNames, tryCount);
			});
	}

	public static Stream argOfThrow() {
		return Stream.of(
			Arguments.of(null, 3),
			Arguments.of(Collections.emptyList(), 3),
			Arguments.of(Arrays.asList("abc", "가나다"), 0),
			Arguments.of(Arrays.asList("abc", "가나다", "xyz"), -5)
		);
	}

	@DisplayName("getter 메서드는 Instance 생성할 때 전달한 파라미터와 값과 동일하고, carCount의 getter 값은 carNames파라미터의 사이즈 값과 동일하다.")
	@ParameterizedTest
	@MethodSource("argGetter")
	void getter(List<String> carNames, int tryCount) {
		InputResult result = InputResult.of(carNames, tryCount);

		assertAll(
			() -> assertThat(result.getCarNames()).isEqualTo(carNames),
			() -> assertThat(result.getCarCount()).isEqualTo(carNames.size()),
			() -> assertThat(result.getTryCount()).isEqualTo(tryCount)
		);
	}

	public static Stream argGetter() {
		return Stream.of(
			Arguments.of(Arrays.asList("abc"), 3),
			Arguments.of(Arrays.asList("abc", "가나다"), 5),
			Arguments.of(Arrays.asList("abc", "가나다", "xyz"), 7)
		);
	}

}