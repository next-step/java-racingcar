package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingCar;
import racing.domain.accelerator.StaticAccelerator;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

	@Test
	@DisplayName("가속페달을 기준보다 많이 밟을 경우 테스트")
	void accelerateOverThreshold(){
		// Arrange
		RacingCar car = new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD + 1));

		// Action & Assertion
		assertThat(car.move()).isGreaterThan(0);
	}

	@Test
	@DisplayName("가속페달을 기준보다 적게 밟을 경우 테스트")
	void accelerateUnderThreshold(){
		// Arrange
		RacingCar car = new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD));

		// Action & Assertion
		assertThat(car.move()).isEqualTo(0);
	}

}