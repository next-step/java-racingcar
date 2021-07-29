package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingTest {

	@Test
	@DisplayName("판단값을 정의하면 그값을 반환한다.")
	public void movableCheck() {
		Moving moving1 = (int randomValue) -> false;

		assertThat(moving1.movable(1)).isFalse();

		Moving moving2 = (int randomValue) -> true;

		assertThat(moving2.movable(5)).isTrue();
	}

}