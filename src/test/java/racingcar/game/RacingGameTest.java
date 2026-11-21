package racingcar.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.car.Cars;

public class RacingGameTest {

	@Test
	void 라운드_1로_시작한_게임은_1번진행후_끝난다() {
		Cars cars = new Cars("pobi");
		RacingGame racingGame = new RacingGame(cars, 1);
		racingGame.play(() -> 3);

		assertThat(racingGame.isFinished()).isTrue();
	}

	@Test
	void 라운드_2로_시작한_게임은_1번진행후_끝나지않는다() {
		Cars cars = new Cars("pobi");
		RacingGame racingGame = new RacingGame(cars, 2);
		racingGame.play(() -> 3);

		assertThat(racingGame.isFinished()).isFalse();
	}
}
