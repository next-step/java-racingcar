package racingGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	private String[] racers ={"pobi","lannstark","teahyuk"};
	private RacingGame racingGame;

	@BeforeEach
	void setting() {
		racingGame = new RacingGame(racers);
	}

	@Test
	@DisplayName("한번 움직였을 때의 결과값 테스트")
	void moveTest() {
		assertThat(racingGame.move().values())
				.containsAnyOf(0, 1);
	}

	@Test
	@DisplayName("여러번 움직였을 때 매번 움직일 때 마다 1칸 전진 또는 제자리 인지 확인 하는 테스트")
	void moveRepeatTest() {
		int moveTime = 5;

		int tmpPosition = 0;
		for (int i = 0; i < moveTime; i++) {
			int nextPosition = racingGame.move().get(racers[0]);
			assertThat(nextPosition)
					.isIn(tmpPosition,tmpPosition+1);
			tmpPosition = nextPosition;
		}
	}

	@Test
	@DisplayName("우승자 확인 테스트")
	void getWinnerTest() {
		int moveTime = 5;
		for (int i = 0; i < moveTime; i++) {
			racingGame.move();
		}

		assertThat(racingGame.getWinners())
				.containsAnyOf(racers);
	}

}