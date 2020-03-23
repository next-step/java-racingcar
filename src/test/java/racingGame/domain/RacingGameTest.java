package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	private static final String RACER1 = "pobi";
	private static final String RACE2 = "lannstark";
	private static final String RACER3 = "teahyuk";

	private static final Engine COMMON_ENGINE = () -> 5;
	private static final Engine BOOST_ENGINE = () -> 10;

	@Test
	@DisplayName("움직임 테스트")
	void moveTest() {
		Car car = new Car(RACER1, COMMON_ENGINE);
		RacingGame racingGame = new RacingGame(car);

		racingGame.move();

		assertThat(car.getDistance())
				.isEqualTo(COMMON_ENGINE.moveDistanceForOneTime());

		racingGame.move();

		assertThat(car.getDistance())
				.isEqualTo(COMMON_ENGINE.moveDistanceForOneTime() * 2);
	}

	@Test
	@DisplayName("우승자 확인 테스트")
	void getWinnerTest() {
		RacingGame racingGame = new RacingGame(new Car(RACER1, COMMON_ENGINE),
				new Car(RACE2, BOOST_ENGINE),
				new Car(RACER3, BOOST_ENGINE));

		racingGame.move();

		assertThat(racingGame.getWinners())
				.containsExactly(RACE2, RACER3);

	}

}