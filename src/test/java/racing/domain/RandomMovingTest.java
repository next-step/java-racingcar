package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMovingTest {

	@Test
	@DisplayName("이동값의 판답값에 따라 true, false 를 반환한다.")
	public void randomMovingCheck() {
		RandomDummyFalseClass randomMoving1 = new RandomDummyFalseClass();
		boolean movable1 = randomMoving1.movable();

		Assertions.assertThat(movable1).isFalse();

		RandomDummyTrueClass randomMoving2 = new RandomDummyTrueClass();
		boolean movable2 = randomMoving2.movable();

		Assertions.assertThat(movable2).isTrue();
	}

	static class RandomDummyFalseClass implements Moving {
		@Override
		public boolean movable() {
			return false;
		}
	}

	static class RandomDummyTrueClass implements Moving {
		@Override
		public boolean movable() {
			return true;
		}
	}
}