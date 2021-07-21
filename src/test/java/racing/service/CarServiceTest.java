package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(carService.getCars().size()).isEqualTo(carCount);
		assertThat(carService.getRepeatCount()).isEqualTo(repeatCount);
	}

	@Test
	@DisplayName("생성된 모든 자동차를 10회 전진 후 상태가 변화하였는지 확인")
	void move_car() throws Exception {
		//given
		int carCount = 3;
		int repeatCount = 10;
		CarService carService = new CarService(carCount, repeatCount);

		//when
		carService.moveCars();
		List<Car> cars = carService.getCars();

		//then
		assertThat(cars)
				.hasSize(carCount)
				.extracting(Car::getForwardCount)
				.isNotEqualTo(0);
	}

}
