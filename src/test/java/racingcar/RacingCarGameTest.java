package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {
	@DisplayName("자동차 경주 게임 생성")
	@Test
	public void testCreateRacingCarGame() {
		//given
		String carNames = "부릉이,부릉부릉이,자동차";
		int roundCount = 5;

		//when
		RacingCarGame game = new RacingCarGame(carNames, roundCount);

		//then
		Assertions.assertThat(game.getParticipatingCarNames()).isEqualTo(carNames.split(","));
	}
}
