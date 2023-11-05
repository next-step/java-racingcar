package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

	@Test
	@DisplayName("nextInt(10)의 값은 0이상 9이하이다")
	void nextInt() {
		assertThat(RacingGame.random())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(9);
	}

	@Test
	@DisplayName("자동차는 random값이 4이상일 때 전진한다")
	void move() {
		String car = "-";

		String after = RacingGame.move(car, 4);

		assertThat(after).isEqualTo(car + "-");
	}

}
