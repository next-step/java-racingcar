package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberMovingStrategyTest {
	@DisplayName("발생된 난수가 9일때는 이동한다")
	@Test
	void moveWhenRandomNumberNine() {
		RandomNumberMovingStrategy randomNumberMovingStrategy = new RandomNumberMovingStrategy();
		randomNumberMovingStrategy.setRandomNumber(new RandomNumberOnlyNine());

		assertThat(randomNumberMovingStrategy.isMoving()).isEqualTo(true);
	}
}