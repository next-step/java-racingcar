package racingwinner.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingwinner.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

	@Test
	@DisplayName("자동차 대수 설정")
	void set_up_car() throws Exception {
		//given
		String[] carNames = {"pobi", "crong", "honux"};

		//when
		CarService carService = new CarService(carNames);

		//then
		assertThat(carService.getCars().size()).isEqualTo(carNames.length);
	}

	@Test
	@DisplayName("생성된 모든 자동차를 10회 전진 후 상태가 변화하였는지 확인")
	void move_car() throws Exception {
		//given
		String[] carNames = {"pobi", "crong", "honux"};
		CarService carService = new CarService(carNames);

		//when
		for (int i = 0; i < 10; i++) {
			carService.moveCars();
		}
		List<Car> cars = carService.getCars();

		//then
		assertThat(cars)
				.hasSize(carNames.length)
				.extracting(Car::getForwardCount)
				.isNotEqualTo(0);
	}

}
