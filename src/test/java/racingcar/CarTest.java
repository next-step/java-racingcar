package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.RacingCarMoveStrategy;

public class CarTest {

	@Test
	@DisplayName("4이상일 경우 이동")
	void move() {
		Car car = new Car("test");
		RacingCarMoveStrategy strategy = new RacingCarMoveStrategy(4);
		car.move(strategy);
		Car dummy = new Car("dummy", 1);
		assertThat(car).isEqualByComparingTo(dummy);
	}

	@Test
	@DisplayName("3이하일 경우 정지")
	void stop() {
		Car car = new Car("test");
		RacingCarMoveStrategy strategy = new RacingCarMoveStrategy(3);
		car.move(strategy);
		Car dummy = new Car("dummy", 0);
		assertThat(car).isEqualByComparingTo(dummy);
	}

	@Test
	@DisplayName("자동차 이름이 5를 초과할 수 없다")
	void carName() {
		assertThatThrownBy(() -> {
			Car car = new Car("5자를초과함");
		}).isExactlyInstanceOf(IllegalArgumentException.class)
			.hasMessage(CarName.NAME_INCORRECT_MESSAGE);
	}
}
