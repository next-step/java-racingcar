package racingwinner.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ragingwinner.domain.Car;
import ragingwinner.service.CarService;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

	@Test
	@DisplayName("자동차 대수 설정")
	void set_up_car() throws Exception {
		//given
		int carCount = 3;

		//when
		CarService carService = new CarService(carCount);

		//then
		assertThat(carService.getCars().size()).isEqualTo(carCount);
	}

	@Test
	@DisplayName("생성된 모든 자동차를 10회 전진 후 상태가 변화하였는지 확인")
	void move_car() throws Exception {
		//given
		int carCount = 3;
		CarService carService = new CarService(carCount);

		//when
		for (int i = 0; i < 10; i++) {
			carService.moveCars();
		}
		List<Car> cars = carService.getCars();

		//then
		assertThat(cars)
				.hasSize(carCount)
				.extracting(Car::getForwardCount)
				.isNotEqualTo(0);
	}

}
