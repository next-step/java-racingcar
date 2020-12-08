package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameModelTest {

	@DisplayName("경주할 자동차 이름을 부여하고 결과 메세지에 이름을 추가한다.")
	@Test
	void 이름을_입력한_경주게임_결과_메세지_TEST() {
		CarGroup carGroup = CarGroup.ofCarNames("pobi,crong,honux", new SimpleMovePolicy());
		RaceGameModel raceGameModel = new RaceGameModel(carGroup);
		RaceGameHistory gameResultMessage = raceGameModel.start(5);

		String expected = "pobi : -----\n" +
			"crong : -----\n" +
			"honux : -----";

		assertThat(gameResultMessage.getLastHistory().parser()).isEqualTo(expected);
	}

	@DisplayName("경주 게임의 승자가 테스트 결과와 일치해야한다")
	@Test
	void 경주게임의_승자_TEST() {
		CarGroup carGroup = CarGroup.ofCarNames("pobi,crong,honux", new SimpleMovePolicy());
		RaceGameModel raceGameModel = new RaceGameModel(carGroup);
		RaceGameHistory gameResultMessage = raceGameModel.start(5);

		String expectedWinner = "pobi,crong,honux";

		assertThat(gameResultMessage.getLastHistory().getDistanceWinner()).isEqualTo(expectedWinner);
	}
}

