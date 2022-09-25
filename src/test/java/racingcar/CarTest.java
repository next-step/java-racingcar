package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.NumberOverFourStrategy;
import racingcar.numberstrategy.FixedNumber;
import racingcar.numberstrategy.NumberStrategy;

public class CarTest {

	MoveStrategy movableStrategy = () -> true;
	MoveStrategy unmovableStrategy = () -> false;

	@Test
	@DisplayName("차는 전진할 수 있다")
	void car_can_move() {
		Car car = new Car();
		car.move(movableStrategy);

		assertThat(car).isGreaterThan(new Car());
	}

	@Test
	@DisplayName("차는 멈춰있을 수 있다")
	void car_can_stay() {
		Car car = new Car();
		car.move(unmovableStrategy);

		assertThat(car).isEqualByComparingTo(new Car());
	}

	@Test
	@DisplayName("차는 위치를 반환할 수 있다")
	void car_can_return_position() {
		Car car = new Car();
		car.move(movableStrategy);

		assertThat(car.getPosition()).isOne();
	}
}
