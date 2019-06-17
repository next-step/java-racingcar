package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.util.RandomValueUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	@DisplayName("랜덤함수 테스트")
	@RepeatedTest(10)
	void getRandomValue() {

		int randomValue = RandomValueUtil.getRandomValue();
		assertThat(randomValue).isGreaterThan(-1)
													 .isLessThan(10);
	}

	@DisplayName("자동차 이동 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 4, 7, 9, 10})
	void move(int movePoint) {
		final Car car = new Car();

		for (int i = 0; i < movePoint; i++) {
			car.move();
		}

		assertThat(car.getStatus()).isEqualTo(movePoint + 1);
	}

	@DisplayName("자동차 생성 테스트")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 7})
	void createCars(int carCount) {
		final Cars cars = new Cars(carCount);
		assertThat(cars.viewCarsStatus()).hasSize(carCount);
	}
}
