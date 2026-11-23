package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {

	@Test
	void 자동차_이름은_null_이될수없다() {
		assertThatThrownBy(() -> new CarName(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void carName객체는_자동차이름을_꺼낼수있다() {
		CarName carName = new CarName("pobi");
		assertThat(carName.getName()).isEqualTo("pobi");
	}
}
