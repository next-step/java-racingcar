package im.juniq.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberMovingStrategyTest {
	@DisplayName("발생된 난수가 5일때는 이동한다")
	@Test
	void moveWhenRandomNumberFive() {
		RandomNumberMovingStrategy randomNumberMovingStrategy =
			new RandomNumberMovingStrategy(new RandomNumberZeroToNine(new Random() {
				@Override
				public int nextInt(int bound) {
					return 5;
				}
			}));

		assertThat(randomNumberMovingStrategy.movable()).isEqualTo(true);
	}

	@DisplayName("발생된 난수가 4일때는 이동하지 않는다")
	@Test
	void stopWhenRandomNumberFour() {
		RandomNumberMovingStrategy randomNumberMovingStrategy =
			new RandomNumberMovingStrategy(new RandomNumberZeroToNine(new Random() {
				@Override
				public int nextInt(int bound) {
					return 4;
				}
			}));

		assertThat(randomNumberMovingStrategy.movable()).isEqualTo(false);
	}
}