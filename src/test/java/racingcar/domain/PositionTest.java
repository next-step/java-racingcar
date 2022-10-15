package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.PositionException;

class PositionTest {

	@Test
	@DisplayName("위치는 증가할 수 있다")
	void position_can_be_increased() {
		Position position = new Position(0);
		Position increasedPosition = position.increase();

		assertThat(increasedPosition).isGreaterThan(position);
	}

	@Test
	@DisplayName("위치는 0 이상이어야 한다")
	void position_is_not_below_zero() {
		assertThatThrownBy(() -> new Position(-1))
			.isInstanceOf(PositionException.class);
	}

}