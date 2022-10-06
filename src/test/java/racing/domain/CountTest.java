package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static racing.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racing.exception.NegativeNumberException;

public class CountTest {

	@DisplayName("count 생성자 예외처리 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, -2, -3})
	void CountConstructorExceptionTest(int value) {
		assertThatThrownBy(() -> {
			Count count = new Count(value);
		}).isInstanceOf(NegativeNumberException.class)
			.hasMessageContaining(POSITIVE_CAN_NOT_BE_NEGATIVE.getErrorMessage());
	}

	@DisplayName("count 생성자 성공 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void CountConstructorSuccessTest(int value) {
		Count count = new Count(value);

		assertThat(count.getCount()).isEqualTo(value);
	}
}
