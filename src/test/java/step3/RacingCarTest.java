package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
	@Test
	@DisplayName("자동차 수 테스트")
	void howManyCars() {
		int actual = Cars.participant("3");
		assertThat(actual).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차 움직임 횟수 테스트")
	void howManyPlayGames() {
		int actual = Cars.move("5");
		assertThat(actual).isEqualTo(5);
	}
}
