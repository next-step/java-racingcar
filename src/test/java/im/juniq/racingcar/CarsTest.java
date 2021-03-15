package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	@DisplayName("자동차 n대를 생성한다")
	@Test
	void createCars() {
		String[] carNames = {"pobi", "poci"};
		Cars cars = new Cars();
		cars.createCars(carNames);

		assertThat(cars).extracting(Car::getName).contains(carNames);
	}

	@DisplayName("자동차 n대를 이동한다")
	@Test
	void moveCars() {
		Car pobi = new Car("pobi", new OnlyTrueMovingStrategy());
		Car poci = new Car("poci", new OnlyTrueMovingStrategy());
		Cars cars = new Cars(pobi, poci);

		cars.move();

		for (Car car: cars) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@DisplayName("가장 먼 위치에 도달한 차 찾기")
	@Test
	void findByTopPosition() {
		Car pobi = new Car("pobi", new OnlyTrueMovingStrategy());
		Car poci = new Car("poci", new RandomNumberMovingStrategy());
		Cars cars = new Cars(pobi, poci);

		for (int i = 0; i < 10; i++) {
			cars.move();
		}

		assertThat(cars.findByTopPosition().get(0)).isEqualTo(pobi);
	}
}