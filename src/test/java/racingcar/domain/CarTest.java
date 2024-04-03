package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void 자동차_이름_부여() {
		Car car = new Car("춘봉", 0);
		assertThat(car.name()).isEqualTo(new Name("춘봉"));
	}

	@DisplayName("자동차 이름은 5글자를 넘을 수 없다")
	@Test
	void carNamelengthUnder5() {
		assertThrows(IllegalArgumentException.class, () -> new Car("프리리리리리리", 0));
	}
}
