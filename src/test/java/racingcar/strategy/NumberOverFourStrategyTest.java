package racingcar.strategy;

import static org.assertj.core.api.Assertions.*;
import static racingcar.strategy.NumberOverFourStrategy.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOverFourStrategyTest {

	MoveStrategy moveStrategyMovable = new NumberOverFourStrategy(() -> MOVE_BOUNDARY_INCLUSIVE);
	MoveStrategy moveStrategyNotMovable = new NumberOverFourStrategy(() -> MOVE_BOUNDARY_INCLUSIVE - 1);

	@DisplayName("숫자가 4 이상이어야 움직일 수 있다")
	@Test
	void number_over_four_is_movable() {
		assertThat(moveStrategyMovable.isMovable()).isTrue();
		assertThat(moveStrategyNotMovable.isMovable()).isFalse();
	}
}
