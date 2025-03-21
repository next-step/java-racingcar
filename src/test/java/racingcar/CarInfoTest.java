package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.CarInfo;

class CarInfoTest {
	@Test
	@DisplayName("거리가 동일하면 true를 반환한다.")
	void isSameLocationTest_sameLocation() {
		// given
		int location = 4;
		CarInfo carInfo = new CarInfo("pobi", location);

		// when
		boolean result = carInfo.isSameLocation(location);

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("거리가 동일하지 않으면 false를 반환한다.")
	void isSameLocationTest_differentLocation() {
		// given
		int location = 4;
		CarInfo carInfo = new CarInfo("pobi", location);

		// when
		boolean result = carInfo.isSameLocation(location + 1);

		// then
		assertThat(result).isFalse();
	}

}
