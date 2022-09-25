package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.NumberOverFourStrategy;
import racingcar.numberstrategy.FixedNumber;
import racingcar.numberstrategy.NumberStrategy;

public class CarTest {

	@Test
	@DisplayName("차는 전진할 수 있다")
	void car_can_move() {
		NumberStrategy numberStrategy = new FixedNumber(4);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		Car car = new Car();
		car.move(moveStrategy);

		assertThat(car).isNotEqualByComparingTo(new Car());
	}

	@Test
	@DisplayName("차는 멈춰있을 수 있다")
	void car_can_stay() {
		NumberStrategy numberStrategy = new FixedNumber(3);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		Car car = new Car();
		car.move(moveStrategy);

		assertThat(car).isEqualByComparingTo(new Car());
	}
}
