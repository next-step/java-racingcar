package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilsTest {
	@DisplayName("전달된 변수가 양수인지 검증")
	@ParameterizedTest(name = "{index}. {0} 은 양수")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void isPositiveNumber(int number) {
		// when
		boolean isPositiveNumber = NumberUtils.isPositiveNumber(number);

		// then
		assertThat(isPositiveNumber).isTrue();
	}

	@DisplayName("전달된 변수가 0 또는 음수인지 검증")
	@ParameterizedTest(name = "{index}. {0} 은 0 또는 음수")
	@ValueSource(ints = {0, -1, -2, -3, -4})
	void isNotPositiveNumber(int number) {
		// when
		boolean isNotPositiveNumber = NumberUtils.isNotPositiveNumber(number);

		// then
		assertThat(isNotPositiveNumber).isTrue();
	}
}
