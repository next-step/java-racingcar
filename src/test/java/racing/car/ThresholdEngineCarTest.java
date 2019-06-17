package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.ThresholdEngineCar;

import static org.assertj.core.api.Assertions.assertThat;

class ThresholdEngineCarTest {

	@Test
	@DisplayName("가속페달을 기준보다 많이 밟을 경우 테스트")
	void accelerateOverThreshold(){
		// Arrange
		int threshold = 5;
		ThresholdEngineCar car = new ThresholdEngineCar(threshold);

		// Action
		car.accelerate(threshold + 1);

		// Assertion
		assertThat(car.getMileage()).isGreaterThan(0);
	}

	@Test
	@DisplayName("가속페달을 기준보다 적게 밟을 경우 테스트")
	void accelerateUnderThreshold(){
		// Arrange
		int threshold = 5;
		ThresholdEngineCar car = new ThresholdEngineCar(threshold);

		// Action
		car.accelerate(threshold - 1);

		// Assertion
		assertThat(car.getMileage()).isEqualTo(0);
	}

}