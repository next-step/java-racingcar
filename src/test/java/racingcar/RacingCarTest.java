package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {
	RacingCar racingCar;

	@BeforeEach
	void setUp() {
		racingCar = new RacingCar();
	}

	@Test
	@DisplayName("forward함수를 n번 호출 했을 때, 자동차의 위치는 0과 같거나 크고 n보다 같거나 작다")
	void forwardTest() {
		int n = 100;
		for (int i = 0 ; i < n ; i++) {
			racingCar.forward();
			assertThat(racingCar.getPos()).isGreaterThanOrEqualTo(0);
			assertThat(racingCar.getPos()).isLessThanOrEqualTo(n);
		}
	}
}
