package racingcar.util.strategy.move;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarMoveStrategyTest {

	@ParameterizedTest
	@ValueSource(ints = {4, 5 ,6})
	@DisplayName("4이상 이면 이동 할 수 있다")
	void movableIsTrue(int valueToMovable) {
		MoveStrategy moveStrategy = new CarMoveStrategy();

		boolean movable = moveStrategy.isMovable(valueToMovable);

		assertThat(movable).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("4미만 이면 이동 할 수 없다")
	void movableIsFalse(int valueToMovable) {
		MoveStrategy moveStrategy = new CarMoveStrategy();

		boolean movable = moveStrategy.isMovable(valueToMovable);

		assertThat(movable).isFalse();
	}
}
