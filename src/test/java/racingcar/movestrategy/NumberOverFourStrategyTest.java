package racingcar.movestrategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.numberstrategy.FixedNumber;

public class NumberOverFourStrategyTest {

	MoveStrategy moveStrategyMovable = new NumberOverFourStrategy(new FixedNumber(4));
	MoveStrategy moveStrategyNotMovable = new NumberOverFourStrategy(new FixedNumber(3));

	@DisplayName("숫자가 4 이상이어야 움직일 수 있다")
	@Test
	void number_over_four_is_movable() {
		assertThat(moveStrategyMovable.isMovable()).isTrue();
		assertThat(moveStrategyNotMovable.isMovable()).isFalse();
	}
}
