package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step3.utils.Validator;

public class ValidatorTest {

	@DisplayName(value = "0보다 작은 수 검증 테스트")
	@ValueSource(ints = {-1, 0})
	@ParameterizedTest
	void validateOverZero(int number) {
		assertThatThrownBy(() -> Validator.validateOverZero(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("0보다 큰 숫자를 입력해주세요!");
	}
}
