package step4.domain.movestrategy;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarMoveStrategyTest {

	@Test
	@DisplayName("DefaultRandomMoveStrategy의 랜덤값이 4 이상일 시 movable이 True인지 체크하는 테스트")
	void biggerThan4IsMovable() {
		CarMoveStrategy defaultRandomMoveStrategy = new RandomMoveStrategy(new Return4Random());
		assertThat(defaultRandomMoveStrategy.movable()).isTrue();
	}

	@Test
	@DisplayName("DefaultRandomMoveStrategy의 랜덤값이 4 미만일 시 movable이 False인지 체크하는 테스트")
	void lessThan4IsMovable() {
		CarMoveStrategy defaultRandomMoveStrategy = new RandomMoveStrategy(new Return3Random());
		assertThat(defaultRandomMoveStrategy.movable()).isFalse();
	}

	@Test
	@DisplayName("AlwaysMoveStrategy 가 항상 움직이는지 체크하는 함수")
	void alwaysMoveTest() {
		CarMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
		for (int i = 0; i < 100; i++) {
			assertThat(alwaysMoveStrategy.movable()).isTrue();
		}
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