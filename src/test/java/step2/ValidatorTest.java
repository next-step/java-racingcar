package step2;

import static org.assertj.core.api.Assertions.*;
import static step2.Validator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
	@DisplayName(value = "빈 문자열 테스트")
	@Test
	void validateEmptyTest() {
		assertThatThrownBy(() -> validateEmpty(" "))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력 값이 비어있어요!");
	}

	@DisplayName(value = "연산 기호 검증 테스트")
	@Test
	void validateOperatorTest() {
		assertThatThrownBy(() -> validateOperator("&"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("연산 기호가 잘못됐어요!");
	}
}