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

	@DisplayName("경주 라운드 횟수와 라운드 점수 현황 일치 확인")
	@Test
	public void testRaceRoundScore() {
		//given
		String carNames = "부릉이,부릉부릉이,자동차";
		int roundCount = 5;

		//when
		RacingCarGame game = new RacingCarGame(carNames, roundCount);

		//then
		Assertions.assertThat(game.getAllRoundScore().size()).isEqualTo(roundCount);
		Assertions.assertThat(game.getAllRoundScore().get(0).size()).isEqualTo(carNames.split(",").length);
	}

	@DisplayName("최종 우승자 한 명 선발")
	@Test
	public void testOnlyOneWinner() {
		//given
		String carName = "부릉이";
		int roundCount = 5;

		//when
		RacingCarGame game = new RacingCarGame(carName, roundCount);

		//then
		Assertions.assertThat(game.getWinners().size()).isEqualTo(1);
		Assertions.assertThat(String.join(",", game.getWinners())).isEqualTo(carName);
	}

	@DisplayName("최종 우승자 선발")
	@Test
	public void testWinners() {
		//given
		String carName = "부릉이,부릉부릉이";
		int roundCount = 5;

		//when
		RacingCarGame game = new RacingCarGame(carName, roundCount);

		//then
		Assertions.assertThat(game.getWinners().size()).isGreaterThanOrEqualTo(1);
		Assertions.assertThat(game.getWinners()).containsAnyOf(carName.split(","));
	}
}
