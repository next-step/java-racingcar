package racingGame.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	private int carCount = 3;
	private RacingGame racingGame;

	@BeforeEach
	void setting() {
		racingGame = new RacingGame(carCount);
	}

	@Test
	@DisplayName("한번 움직였을 때의 결과값 테스트")
	void moveTest() {
		assertThat(racingGame.move())
				.containsAnyOf(0, 1);
	}

	@Test
	@DisplayName("여러번 움직였을 때 매번 움직일 때 마다 1칸 전진 또는 제자리 인지 확인 하는 테스트")
	void moveRepeatTest() {
		int moveTime = 5;

		int tmpPosition = 0;
		for (int i = 0; i < moveTime; i++) {
			int nextPosition = racingGame.move()[0];
			assertThat(nextPosition)
					.isIn(tmpPosition,tmpPosition+1);
			tmpPosition = nextPosition;
		}
	}

}