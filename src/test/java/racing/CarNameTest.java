package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.CarName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

	@Test
	@DisplayName("자동차 이름은 5자를 초과할 수 없다")
	void name() {
		assertThatThrownBy(() -> {
			new CarName("abcdef");
		}).isInstanceOf(IllegalArgumentException.class);
	}

}