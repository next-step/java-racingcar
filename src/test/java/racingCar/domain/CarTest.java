package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@ParameterizedTest(name = "자동차는 파워가 기준 이상일 때 이동해야 한다 "
		+ "파워: {arguments}")
	@ValueSource(ints = { Car.POWER_THRESHOLD, Car.POWER_THRESHOLD + 1, Car.POWER_THRESHOLD + 2})
	void drive_over_threshold(int power) {
		Car car = Car.create(power);
		int given = car.getDistanceList().size();

		car.accelerate();
		int actual = car.getDistanceList().size();

		assertThat(actual).isGreaterThan(given);
	}

	@Test
	@DisplayName("자동차는 파워가 기준 미만일 때는 이동하지 않아야 한다.")
	void drive_not_under_threshold() {
		Car car = Car.create(Car.POWER_THRESHOLD - 1);
		int given = car.getDistanceList().size();

		car.accelerate();
		int actual = car.getDistanceList().size();

		assertThat(actual).isEqualTo(given);
	}

	@ParameterizedTest(name = "파워가 이동 가능한 만큼 충분한 자동차는 "
		+ "{arguments}회 엑셀을 밟으면 {arguments} 만큼 이동한다")
	@ValueSource(ints = { 1, 2, 3, 4, 5 })
	void drive_arguments_mile(int count) {
		Car car = Car.create(Car.POWER_THRESHOLD);

		for (int i = 0; i < count; i++) {
			car.accelerate();
		}

		assertThat(car.getDistanceList()).hasSize(count);
	}
}
