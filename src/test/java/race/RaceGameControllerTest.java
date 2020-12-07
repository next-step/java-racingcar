package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceGameControllerTest {

	@DisplayName("경주할 자동차 이름을 부여하고 결과 메세지에 이름을 추가한다.")
	@Test
	void GameProcessor_findWinner_TEST() {
		InputValue inputValue = new InputValue("pobi,crong,honux", 5);
		RaceGameController raceGameController = new RaceGameController(inputValue, new SimpleMovePolicy());
		raceGameController.start();

		String expected = "pobi : -----\n" +
			"crong : -----\n" +
			"honux : -----";


		assertThat(raceGameController.getNowCarsMoveStatus()).isEqualTo(expected);
	}
}

