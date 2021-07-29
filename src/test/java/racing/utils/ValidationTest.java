package racing.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

	private static final String VALID_EMPTY_MESSAGE = "빈갑이 입력될 수 없습니다.";
	private static final String VALID_INT_TYPE_MESSAGE = "숫자만 입력이 가능합니다.";
	private static final String STRING_LIMIT_LENGTH_MESSAGE = "최소길이를 초과하였습니다.";
	private static final String POSITIVE_CHECK_MESSAGE = "음수가 입력되었습니다.";

	@Test
	@DisplayName("빈값을 입력하면 예외가 발생된다.")
	public void validEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validEmptyCheck("", VALID_EMPTY_MESSAGE)
		);

		assertThatThrownBy(() -> Validation.validEmptyCheck("", VALID_EMPTY_MESSAGE))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(VALID_EMPTY_MESSAGE);
	}

	@Test
	@DisplayName("숫자형태가 아닌 다른 문자를 입력하면 예외가 발생된다.")
	public void validIntTypeMatchCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validIntTypeMatchCheck("", VALID_INT_TYPE_MESSAGE)
		);

		assertThatThrownBy(() -> Validation.validIntTypeMatchCheck("+1", VALID_INT_TYPE_MESSAGE))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(VALID_INT_TYPE_MESSAGE);
	}

	@Test
	@DisplayName("입력받은 문자열이 최소길이를 초과하면 예외가 발생된다.")
	public void validStringLength() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validStringLength("lastTest", 7, STRING_LIMIT_LENGTH_MESSAGE)
		);

		assertThatThrownBy(() -> Validation.validStringLength("lamda", 4, STRING_LIMIT_LENGTH_MESSAGE))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(STRING_LIMIT_LENGTH_MESSAGE);
	}

	@Test
	@DisplayName("음수를 입력하면 예외가 발생된다.")
	public void validPositiveCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validPositiveCheck(-5, POSITIVE_CHECK_MESSAGE)
		);

		assertThatThrownBy(() -> Validation.validPositiveCheck(-9, POSITIVE_CHECK_MESSAGE))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(POSITIVE_CHECK_MESSAGE);
	}

}