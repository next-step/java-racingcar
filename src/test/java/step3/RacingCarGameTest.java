package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

	@Test
	@DisplayName("게임 결과의 갯수가 맞는지 확인한다.")
	void playTest() {
		int carNumber = 3;
		int tryNumber = 5;
		RacingCarGame racingCarGame = new RacingCarGame(carNumber,tryNumber);
		Records records = racingCarGame.play();

		assertThat(records.getResult()).hasSize(tryNumber);
		assertThat(records.getResult().get(0)).hasSize(carNumber);
	}
}
