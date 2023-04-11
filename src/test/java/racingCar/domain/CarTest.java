package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@Test
	@DisplayName("자동차는 파워가 기준 미만일 때는 이동하지 않아야 한다.")
	void drive_only_over_4_power() {
		Car car = Car.of(Car.POWER_THRESHOLD - 1);
		List<Distance> given = car.getDistanceList();

		car.accelerate();

		assertThat(car.getDistanceList()).isEqualTo(given);
	}

	@ParameterizedTest(name = "파워가 이동 가능한 만큼 충분한 자동차는 "
		+ "{arguments}회 엑셀을 밟으면 {arguments} 만큼 이동한다")
	@ValueSource(ints = { 1, 2, 3, 4, 5 })
	void drive_arguments_mile(int count) {
		Car car = Car.of(Car.POWER_THRESHOLD);

		for (int i = 0; i < count; i++) {
			car.accelerate();
		}

		assertThat(car.getDistanceList()).hasSize(count);
	}
}
