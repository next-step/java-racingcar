package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarCountTest {

	@Test
	@DisplayName("자동차 대수 생성")
	public void numberOfCars() {
		CarCount carCount = new CarCount(3);
		assertThat(carCount.count()).isEqualTo(3);
	}

}
