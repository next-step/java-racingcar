package racinggame;

import org.junit.Test;
import racinggame.car.CarDTO;
import racinggame.rule.RacingGameRule;
import racinggame.rule.RandomNumberRacingGameRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGameTest {

	@Test
	public void test_레이싱게임_생성() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGame racingGame = new RacingGame(testData, 5, new RandomNumberRacingGameRule());

		assertThat(racingGame.getCarDtoList().size()).isEqualTo(3);
		assertThat(racingGame.hasNextGame()).isTrue();
	}

	@Test
	public void test_자동차_이동_확인() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGame racingGame = new RacingGame(testData, 5, (car) -> true);

		racingGame.move();

		List<CarDTO> cars = racingGame.getCarDtoList();
		for (CarDTO car : cars) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@Test
	public void test_자동차_미이동_확인() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGame racingGame = new RacingGame(testData, 5, (car) -> false);

		racingGame.move();

		List<CarDTO> cars = racingGame.getCarDtoList();
		for (CarDTO car : cars) {
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}

	@Test
	public void test_현재_상위랭커_리스트_1등() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGameRule racingGameRule = RacingGameTestHelper.racingGameRuleByCarName(testData[0]);

		RacingGame racingGame = new RacingGame(testData, 5, racingGameRule);
		racingGame.move();

		List<CarDTO> actual = racingGame.getTopRankingCarDtoList();

		assertThat(actual.size()).isEqualTo(1);
		assertThat(actual.get(0).getName()).isEqualTo(testData[0]);
		assertThat(actual.get(0).getPosition()).isEqualTo(1);
	}

	@Test
	public void test_현재_상위랭커_리스트_공동1등() {
		String[] testData = RacingGameTestHelper.createTestData(3);
		RacingGameRule racingGameRule = RacingGameTestHelper.racingGameRuleByCarName(testData[0], testData[1]);

		RacingGame racingGame = new RacingGame(testData, 5, racingGameRule);
		racingGame.move();
		List<CarDTO> actual = racingGame.getTopRankingCarDtoList();

		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual).extracting("name").contains(testData[0], testData[1]);
		assertThat(actual).extracting("position").contains(1, 1);
	}

}