package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.level3.domain.Cars;
import carRacing.level3.service.CarService;
import carRacing.level3.service.RandomMovingStartegy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

	public static final Integer CAR_SUM = 3;
	public static final Integer DEFAULT_LOCATION = 1;
	CarService carService = new CarService();

	@Test
	@DisplayName("경주를 위해 자동차 컬렉션을 생성한다")
	void 경주_준비() {
		assertThat(carService.prepare(CAR_SUM).getClass()).isEqualTo(Cars.class);
	}

	@Test
	@DisplayName("경주를 진행한다")
	void 경주_진행() {
		Cars cars = carService.prepare(CAR_SUM);
		carService.moveCar(3,cars,new RandomMovingStartegy());
		for (int i = 0; i < CAR_SUM; i++) {
			assertThat(cars.carLocation(i)).isGreaterThanOrEqualTo(DEFAULT_LOCATION);
		}
	}
}
