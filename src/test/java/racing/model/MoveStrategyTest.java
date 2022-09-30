package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {

	@DisplayName("random 값이 4이상일 때 움직인다.")
	@Test
	void moveCondition() {
		RandomNumber randomNumber = new RandomNumber() {
			@Override
			public int getRandomNumber() {
				return 4;
			}
		};
		MoveStrategy moveStrategy = new MoveStrategy(randomNumber);
		boolean movable = moveStrategy.isMovable();
		assertThat(movable).isTrue();
	}

	@DisplayName("random 값이 3이하일 때 움직이지 않는다.")
	@Test
	void notMoveCondition() {
		RandomNumber randomNumber = new RandomNumber() {
			@Override
			public int getRandomNumber() {
				return 3;
			}
		};
		MoveStrategy moveStrategy = new MoveStrategy(randomNumber);
		boolean movable = moveStrategy.isMovable();
		assertThat(movable).isFalse();
	}

}
