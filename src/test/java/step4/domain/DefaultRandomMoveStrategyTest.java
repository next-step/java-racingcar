package step4.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultRandomMoveStrategyTest {

	@Test
	@DisplayName("DefaultRandomMoveStrategy의 랜덤값이 4 이상일 시 움직이는 테스트")
	void biggerThan4IsMovable() {
		CarMoveStrategy defaultRandomMoveStrategy = new DefaultRandomMoveStrategy(new Return4Random());
		assertThat(defaultRandomMoveStrategy.movable()).isTrue();
	}

	@Test
	@DisplayName("DefaultRandomMoveStrategy의 랜덤값이 4 미만일 시 움직이지 않는 테스트")
	void lessThan4IsMovable() {
		CarMoveStrategy defaultRandomMoveStrategy = new DefaultRandomMoveStrategy(new Return3Random());
		assertThat(defaultRandomMoveStrategy.movable()).isFalse();
	}

	static class Return4Random extends Random {
		@Override
		public int nextInt(int value) {
			return 4;
		}
	}

	static class Return3Random extends Random {
		@Override
		public int nextInt(int value) {
			return 3;
		}
	}
}