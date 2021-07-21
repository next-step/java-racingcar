package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

	@Test
	@DisplayName("자동차 대수, 반복 횟수 설정")
	void set_up_car() throws Exception {
		//given
		int carCount = 3;
		int repeatCount = 5;

		//when
		CarService carService = new CarService(carCount, repeatCount);

		//then
		assertThat(carService.carsCount()).isEqualTo(carCount);
		assertThat(carService.getRepeatCount()).isEqualTo(repeatCount);
	}

}
