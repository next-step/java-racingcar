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

		assertThat(cars.get().size()).isEqualTo(carNames.length);
	}

	@DisplayName("자동차 n대를 이동한다")
	@Test
	void moveCars() {
		String[] carNames = {"pobi", "poci"};
		Cars cars = new Cars();
		cars.createCars(carNames);

		cars.move();

		for (int i = 0; i < cars.get().size(); i++) {
			Car car = cars.get(i);
			assertThat(car.getName()).isEqualTo(carNames[i]);
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@DisplayName("가장 먼 위치에 도달한 차 찾기")
	@Test
	void findByTopPosition() {
		Car pobi = new Car("pobi", new OnlyTrueMovingStrategy());
		Car poci = new Car("poci", new RandomNumberMovingStrategy());

		Cars cars = new Cars();
		cars.add(pobi, poci);

		for (int i = 0; i < 10; i++) {
			cars.move();
		}

		assertThat(cars.findByTopPosition().get(0)).isEqualTo(pobi);
	}
}