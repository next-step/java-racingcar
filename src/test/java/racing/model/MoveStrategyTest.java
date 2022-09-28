package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {

	@DisplayName("random 값이 4이상일 때 움직인다.")
	@Test
	void moveCondition() {
		MoveStrategy moveStrategy = new MoveStrategy();
		boolean movable = moveStrategy.isMovable(4);
		assertThat(movable).isTrue();
	}

	@DisplayName("random 값이 3이하일 때 움직이지 않는다.")
	@Test
	void notMoveCondition() {
		MoveStrategy moveStrategy = new MoveStrategy();
		boolean movable = moveStrategy.isMovable(3);
		assertThat(movable).isFalse();
	}
}
