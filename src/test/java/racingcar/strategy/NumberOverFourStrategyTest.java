package racingcar.strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOverFourStrategyTest {

	private final MoveStrategy moveStrategyMovable = new NumberOverFourStrategy(() -> 4);
	private final MoveStrategy moveStrategyNotMovable = new NumberOverFourStrategy(() -> 3);

	@DisplayName("숫자가 4 이상이어야 움직일 수 있다")
	@Test
	void number_over_four_is_movable() {
		assertThat(moveStrategyMovable.isMovable()).isTrue();
		assertThat(moveStrategyNotMovable.isMovable()).isFalse();
	}
}
