package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import im.juniq.racingcar.domain.Car;
import im.juniq.racingcar.domain.OnlyTrueMovingStrategy;
import im.juniq.racingcar.domain.RacingGame;
import im.juniq.racingcar.domain.RandomNumberMovingStrategy;
import im.juniq.racingcar.domain.CarState;

class RacingGameTest {
	@DisplayName("자동차 n대를 생성한다")
	@Test
	void createCars() {
		String[] carNames = {"pobi", "poci"};
		RacingGame racingGame = new RacingGame();

		assertThatCode(() -> racingGame.createCars(carNames, new RandomNumberMovingStrategy()))
			.doesNotThrowAnyException();
	}

	@DisplayName("자동차 n대를 이동한다")
	@Test
	void moveCars() {
		Car pobi = new Car("pobi", new OnlyTrueMovingStrategy());
		Car poci = new Car("poci", new OnlyTrueMovingStrategy());
		RacingGame racingGame = new RacingGame(pobi, poci);

		racingGame.move();

		for (CarState carState : racingGame.carStates()) {
			assertThat(carState.position()).isEqualTo(1);
		}
	}

	@DisplayName("가장 먼 위치에 도달한 차 찾기")
	@Test
	void findByTopPosition() {
		Car pobi = new Car("pobi", new OnlyTrueMovingStrategy());
		Car poci = new Car("poci", new RandomNumberMovingStrategy());
		RacingGame racingGame = new RacingGame(pobi, poci);

		for (int i = 0; i < 10; i++) {
			racingGame.move();
		}

		for (CarState winner: racingGame.getWinners()) {
			assertThat(winner).isEqualToComparingFieldByField(new CarState("pobi", 10));
		}
	}
}
