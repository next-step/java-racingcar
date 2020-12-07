package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValueTest {

	@DisplayName("자동차 이름이 5자를 초과 할 수 없는 기능 테스트")
	@Test
	void 입력값_허용치_초과_테스트() {
		assertThatThrownBy(() -> {
			InputValue.ofSeparatorValues("test101010,test");
		})
			.isInstanceOf(IllegalInputNameException.class)
			.hasMessageContaining(String.format(IllegalInputNameException.ILLEGAL_INPUT_FORMAT_MESSAGE, InputValue.MAX_INPUT_NAME_LENGTH))
		;
	}
}
