package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.RacingGame;
import study.racingcar.domain.UserChoice;

public class RacingGameTest {

	@Test
	@DisplayName("게임 시작")
	void getGameStatus() {

		int carCount = 5;
		int gameRounds = 10;

		UserChoice userChoice = new UserChoice(carCount, gameRounds);
		RacingGame game = new RacingGame(userChoice);
		game.playGame();

	}
}
