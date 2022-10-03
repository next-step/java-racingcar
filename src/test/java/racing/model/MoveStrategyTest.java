package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {

	@DisplayName("random 값이 4이상일 때 움직인다.")
	@Test
	void moveCondition() {
		NumberGenerator numberGenerator = () -> 4;
		MoveStrategy moveStrategy = new MoveStrategy(numberGenerator);
		assertThat(moveStrategy.isMovable()).isTrue();
	}

	@DisplayName("random 값이 3이하일 때 움직이지 않는다.")
	@Test
	void notMoveCondition() {
		NumberGenerator numberGenerator = () -> 3;
		MoveStrategy moveStrategy = new MoveStrategy(numberGenerator);
		assertThat(moveStrategy.isMovable()).isFalse();
	}
}
