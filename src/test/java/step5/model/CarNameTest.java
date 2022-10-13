package step5.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameTest {
	@Test
	void 자동차_이름_조건_판별조건_확인() {
		Assertions.assertThatThrownBy(
				() -> new Car("hihihi")).isInstanceOf(IllegalArgumentException.class);
	}
}