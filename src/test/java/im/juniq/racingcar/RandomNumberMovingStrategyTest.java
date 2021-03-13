package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberMovingStrategyTest {
	@DisplayName("발생된 난수가 5일때는 이동한다")
	@Test
	void moveWhenRandomNumberNine() {
		RandomNumberMovingStrategy randomNumberMovingStrategy = new RandomNumberMovingStrategy();
		randomNumberMovingStrategy.setRandomNumber(new RandomNumberZeroToNine(new Random() {
			@Override
			public int nextInt(int bound) {
				return 5;
			}
		}));

		assertThat(randomNumberMovingStrategy.isMoving()).isEqualTo(true);
	}
}