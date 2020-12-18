package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utils.Message;

public class NameTest {
	@Test
	@DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException이 발생한다.")
	void validatePositiveTest_ThrowIllegalArgumentExceptionWhenNegative() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Name("abcdefg"))
			.withMessage(Message.INVALID_CAR_NAME_LENGTH);
	}
}
