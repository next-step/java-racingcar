package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
	@Test
	@DisplayName("자동차 이름은 적어도 1글자 이상 5글자 이하이어야 한다.")
	void nameLengthTest() {
		assertThatThrownBy(() ->
				new CarName("hihihi")
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				new CarName("")
		).isInstanceOf(IllegalArgumentException.class);
	}
}