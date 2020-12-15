package step3.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

	@Test
	@DisplayName("음수를 넣으면 IllegalArgumentException이 발생한다.")
	void validatePositiveTest_ThrowIllegalArgumentExceptionWhenNegative() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ValidationUtils.validatePositive(-1))
			.withMessage(Message.INVALID_POSITIVE_NUMBER);
	}

	@Test
	@DisplayName("null이거나 빈 문자열을 넣으면 IllegalArgumentException이 발생한다.")
	void validateEmptyTest_ThrowIllegalArgumentExceptionWhenNegative() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ValidationUtils.validateEmpty(null))
			.withMessage(Message.INVALID_EMPTY_STRING);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> ValidationUtils.validateEmpty(""))
			.withMessage(Message.INVALID_EMPTY_STRING);
	}
}