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
		assertThat(racingGame.getTime())
				.isEqualTo(1);
	}

	@Test
	@DisplayName("여러번 움직였을 때의 움직인 횟수 확인 테스트")
	void moveCountTest() {

		int moveTime = 5;

		for (int i = 0; i < moveTime; i++) {
			racingGame.move();
		}

		assertThat(racingGame.getTime())
				.isEqualTo(moveTime);
	}

}