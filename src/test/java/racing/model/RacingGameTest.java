package racing.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racing.model.service.ForwardCarConditional;
import racing.model.service.RandomCarConditional;
import racing.model.service.StopCarConditional;

class RacingGameTest {

	@ParameterizedTest
	@ValueSource(strings = {"코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("우승자 랜덤 테스트")
	void getRandomWinnerTest(CarNames winnerNames) {

		RandomCarConditional random = new RandomCarConditional();

		// 자동차 경주 게임 객체 생성
		RacingGame game = new RacingGame(winnerNames);

		game.start(random);
		game.start(random);
		game.start(random);

		// 최소 한명의 우승자가 나와야 한다.
		assertThat(game.getWinner()).isNotEmpty();
	}

	@ParameterizedTest
	@ValueSource(strings = {"코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("우승자 공동우승 테스트")
	void getAllWinnerTest(CarNames winnerNames) {

		ForwardCarConditional forwardCarConditional = new ForwardCarConditional();

		// 자동차 경주 게임 객체 생성
		RacingGame game = new RacingGame(winnerNames);

		game.start(forwardCarConditional);
		game.start(forwardCarConditional);

		// 모든 차량이 주행을 동일하게 했기 때문에 모든 차량이 우승자 이여야 한다.
		// assertThat(game.getWinner().replace(" ", "")).isEqualTo(winnerNames);

		for (RacingCar car : game.getRacingCars()) {

			// 모든 차량이 주행을 2번했기 때문에 2
			assertThat(car.getDistance()).isEqualTo(2);
		}
	}

	@ParameterizedTest
	@ValueSource(strings = {"코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("우승자 주행거리 0 테스트")
	void getZeroWinnerTest(CarNames winnerNames) {

		// 자동차 경주 게임 객체 생성 // 모든차량 주행거리 0
		RacingGame game = new RacingGame(winnerNames);

		// 주행을 안했기 때문에, 차량 리스트 전부가 우승자이여야 한다.
		// assertThat(game.getWinner().replace(" ", "")).isEqualTo(winnerNames);

		game.start(new StopCarConditional());
		game.start(new StopCarConditional());
		game.start(new StopCarConditional());

		// assertThat(game.getWinner().replace(" ", "")).isEqualTo(winnerNames);
	}

	@ParameterizedTest
	@ValueSource(strings = {"코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("레이싱 게임 객체 생성 테스트")
	void createRacingGameTest(CarNames carNames) {

		RacingGame game = new RacingGame(carNames);

		assertThat(game).isNotNull();
	}
}
