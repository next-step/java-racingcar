package racinggame;

import org.junit.Test;
import racinggame.rule.RandomNumberRacingGameRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGameTest {
	@Test
	public void test_레이싱게임_생성() {
		RacingGame racingGame = new RacingGame(5, 5, new RandomNumberRacingGameRule());

		assertThat(racingGame.getCars().size()).isEqualTo(5);
		assertThat(racingGame.getRemainTryCount()).isEqualTo(5);
	}

	@Test
	public void test_자동차_이동_확인() {
		RacingGame racingGame = new RacingGame(5, 5, () -> true);

		racingGame.move();

		List<Car> cars = racingGame.getCars();
		for (Car car : cars) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@Test
	public void test_자동차_미이동_확인() {
		RacingGame racingGame = new RacingGame(5, 5, () -> false);

		racingGame.move();

		List<Car> cars = racingGame.getCars();
		for (Car car : cars) {
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}
}