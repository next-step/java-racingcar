package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.strategy.MoveStrategy;

public class CarTest {

	MoveStrategy moveStrategyMovable = () -> true;
	MoveStrategy moveStrategyNotMovable = () -> false;

	@Test
	@DisplayName("차는 전진할 수 있다")
	void car_can_move() {
		Car car = new Car();
		car.move(moveStrategyMovable);

		assertThat(car).isGreaterThan(new Car());
	}

	@Test
	@DisplayName("차는 멈춰있을 수 있다")
	void car_can_stay() {
		Car car = new Car();
		car.move(moveStrategyNotMovable);

		assertThat(car).isEqualByComparingTo(new Car());
	}

	@Test
	@DisplayName("차는 위치를 반환할 수 있다")
	void car_can_return_position() {
		Car car = new Car();
		car.move(moveStrategyMovable);

		assertThat(car.getPosition()).isOne();
	}
}
