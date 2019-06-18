package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class ThresholdEngineCarTest {

	@Test
	@DisplayName("가속페달을 기준보다 많이 밟을 경우 테스트")
	void accelerateOverThreshold(){
		// Arrange
		RacingCar car = new RacingCar();

		// Action
		car.move(RacingCar.DEFAULT_THRESHOLD + 1);

		// Assertion
		assertThat(car.getMileage()).isGreaterThan(0);
	}

	@Test
	@DisplayName("가속페달을 기준보다 적게 밟을 경우 테스트")
	void accelerateUnderThreshold(){
		// Arrange
		RacingCar car = new RacingCar();

		// Action
		car.move(RacingCar.DEFAULT_THRESHOLD);

		// Assertion
		assertThat(car.getMileage()).isEqualTo(0);
	}

}