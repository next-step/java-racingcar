package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingGame;

public class RacingGameTest {

	@Test
	@DisplayName("우승자 구하기")
	void getWinner() {
		String pobi = "pobi";
		String crong = "crong";
		String honux = "honux";
		String comma = ",";
		RacingGame game = new RacingGame(pobi + comma + crong + comma + honux);
		game.run();
		assertThat(game.getWinners()).containsAnyOf(pobi, crong, honux);
	}

	@Test
	@DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다")
	void getResult() {
		String pobi = "pobi";
		String crong = "crong";
		String honux = "honux";
		String comma = ",";
		RacingGame game = new RacingGame(pobi + comma + crong + comma + honux);
		game.run();
		assertThat(game.getGameResult()).containsKeys(pobi, crong, honux);
	}
}
