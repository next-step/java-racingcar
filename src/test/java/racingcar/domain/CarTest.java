package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.generator.NumberGenerator;
import racingcar.util.strategy.move.CarMoveStrategy;
import racingcar.util.strategy.move.MoveStrategy;

class CarTest {

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("자동차 객체가 움직일때 전달받은 값이 4이상이면 자동차는 한칸 전진한다")
	void movableTrue(int number) {
		NumberGenerator generator = () -> number;
		MoveStrategy moveStrategy = new CarMoveStrategy();
		Car car = new Car(generator, moveStrategy);

		car.move();

		assertThat(car.carStatus()).contains("-");
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("자동차 객체가 움직일때 전달받은 값이 4이상이 아니라면 자동차는 전진하지 않는다")
	void movableFalse(int number) {
		NumberGenerator generator = () -> number;
		MoveStrategy moveStrategy = new CarMoveStrategy();
		Car car = new Car(generator, moveStrategy);

		car.move();

		assertThat(car.carStatus()).doesNotContain("-");
	}

}
