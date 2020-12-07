package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceGameControllerTest {

	@DisplayName("경주할 자동차 이름을 부여하고 결과 메세지에 이름을 추가한다.")
	@Test
	void 이름을_입력한_경주게임_결과_메세지_TEST() {
		InputValue inputValue = new InputValue("pobi,crong,honux", 5);
		RaceGameController raceGameController = new RaceGameController(inputValue, new SimpleMovePolicy());
		raceGameController.start();

		String expected = "pobi : -----\n" +
			"crong : -----\n" +
			"honux : -----";

		assertThat(raceGameController.getNowCarsMoveStatus()).isEqualTo(expected);
	}

	@DisplayName("경주 게임의 승자가 테스트 결과와 일치해야한다")
	@Test
	void 경주게임의_승자_TEST() {
		InputValue inputValue = new InputValue("pobi,crong,honux", 5);
		RaceGameController raceGameController = new RaceGameController(inputValue, new SimpleMovePolicy());
		raceGameController.start();

		String expectedWinner = "pobi,crong,honux";

		assertThat(raceGameController.getRaceGameWinner()).isEqualTo(expectedWinner);
	}
}

