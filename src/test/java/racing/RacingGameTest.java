package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	@Test
	@DisplayName("nextInt(10)의 값은 0이상 9이하이다")
	void nextInt() {
		assertThat(RacingGame.random())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(9);
	}

	@ParameterizedTest
	@DisplayName("자동차는 random값이 4미만일 때 가만히 있고 4이상일 때 전진한다")
	@CsvSource({"0,-", "1,-", "2,-", "3,-", "4,--", "5,--", "6,--", "7,--", "8,--", "9,--"})
	void dont_move(Integer random, String expected) {
		assertThat(RacingGame.move("-", random)).isEqualTo(expected);
	}
}
