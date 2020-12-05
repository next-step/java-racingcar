package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

	RacingCar racingCar = new RacingCar();

	@Test
	@DisplayName("랜덤값이 4이상인 경우 한 칸 전진한다.")
	void test_forward() {
		assertThat(racingCar.isForward(4)).isTrue();
		assertThat(racingCar.isForward(0)).isFalse();
		assertThat(racingCar.isForward(-1)).isFalse();
	}

}