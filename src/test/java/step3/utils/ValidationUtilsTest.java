package step3.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

	@Test
	@DisplayName("음수를 넣으면 IllegalArgumentException이 발생한다.")
	void validPositiveTest_ThrowIllegalArgumentExceptionWhenNegative() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ValidationUtils.validPositive(-1))
			.withMessage(Message.INVALID_POSITIVE_NUMBER);
	}
}