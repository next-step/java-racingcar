package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

	@Test
	@DisplayName("nextInt(10)의 값은 0이상 9이하이다")
	void nextInt() {
		Assertions.assertThat(RacingGame.random())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(9);
	}


}
