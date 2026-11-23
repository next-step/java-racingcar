package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "pobiii"})
	void 자동차이름이_빈문자열이거나_5자초과면_예외를발생한다(String carName) {
		assertThatThrownBy(() -> new CarName(carName))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
