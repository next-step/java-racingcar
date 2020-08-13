package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CarNameTest {

	@DisplayName("이름이 5자 이상인 경우 예외 처리 테스트")
	@Test
	void nameValidCheck() {
		assertThatIllegalArgumentException().isThrownBy(() -> new CarName("sondami"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}