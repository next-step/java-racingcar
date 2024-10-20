package step5.domain.movestrategy;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarMoveStrategyTest {
	private static final CarMoveStrategy TEST_ALWAYS_MOVE_STRATEGY = new RandomMoveStrategy(new Return4Random());
	private static final CarMoveStrategy TEST_ALWAYS_STOP_STRATEGY = new RandomMoveStrategy(new Return3Random());

	@Test
	@DisplayName("DefaultRandomMoveStrategy의 랜덤값이 4 이상일 시 movable이 True인지 체크하는 테스트")
	void biggerThan4IsMovable() {
		assertThat(TEST_ALWAYS_MOVE_STRATEGY.movable()).isTrue();
	}

	@Test
	@DisplayName("DefaultRandomMoveStrategy의 랜덤값이 4 미만일 시 movable이 False인지 체크하는 테스트")
	void lessThan4IsMovable() {
		assertThat(TEST_ALWAYS_STOP_STRATEGY.movable()).isFalse();
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