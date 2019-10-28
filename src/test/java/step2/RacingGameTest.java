package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
	RacingGame racingGame;
	private int carNum = 3;
	private int time = 5;

	@BeforeEach
	void setUp() {
		racingGame = new RacingGame(carNum, time);
	}

	@Test
	void createdCarNumTest() {
		assertThat(racingGame.getCarPositions()).hasSize(carNum);
	}

	@Test
	void randomNumTest() {
		assertThat(racingGame.getRandomNum()).isBetween(0, 9);
	}

	@Test
	void runTest() {
		racingGame.run();
		assertThat(racingGame.getCarPositionsList()).hasSize(time + 1);    // 초기 위치값 저장으로 인해 time + 1과 비교
	}
}
