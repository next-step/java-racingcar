package racinggame.domain;

import org.junit.Test;
import racinggame.domain.rule.RandomNumberRacingGameRule;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGameTest {

	@Test
	public void test_레이싱게임_생성() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGame racingGame = new RacingGame(testData, 5, new RandomNumberRacingGameRule());

		assertThat(racingGame.getCarDtoList()).hasSize(3);
		assertThat(racingGame.hasNextGame()).isTrue();
	}

	@Test
	public void test_자동차_게임이_끝났을_때() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGame racingGame = new RacingGame(testData, 1, (car) -> true);

		racingGame.move();

		assertThat(racingGame.hasNextGame()).isFalse();
	}

	@Test
	public void test_자동차_게임이_끝나지않았을_때() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGame racingGame = new RacingGame(testData, 2, (car) -> true);

		racingGame.move();

		assertThat(racingGame.hasNextGame()).isTrue();
	}

}