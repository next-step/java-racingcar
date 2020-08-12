package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import static step4.NameValidator.splitValidName;

class NameValidatorTest {

	@DisplayName("이름이 5자 이상인 경우 예외 처리 테스트")
	@Test
	void nameValidCheck() {
		assertThatIllegalArgumentException().isThrownBy(() -> splitValidName("dami,mongzza,dam,corgi"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}