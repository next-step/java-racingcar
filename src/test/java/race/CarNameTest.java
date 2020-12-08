package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {

	@DisplayName("자동차 이름이 5자를 초과 할 수 없는 기능 테스트")
	@Test
	void 자동차_이름_초과_테스트() {
		assertThatThrownBy(() -> {
			CarName.of("1234567");
		})
			.isInstanceOf(IllegalInputNameException.class)
			.hasMessageContaining(String.format(IllegalInputNameException.ILLEGAL_INPUT_FORMAT_MESSAGE, CarName.MAX_INPUT_NAME_LENGTH));
	}

}
