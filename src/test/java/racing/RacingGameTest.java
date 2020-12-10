package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racing.model.RacingCar;
import racing.model.RacingGame;
import racing.model.service.ForwardCarConditional;

class RacingGameTest {

	@ParameterizedTest
	@ValueSource(strings = {"M4", "코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("우승자 랜덤 테스트")
	void getRandomWinnerTest(String winnerNames) {

		ForwardCarConditional forwardCarConditional = new ForwardCarConditional();

		// 자동차 경주 게임 객체 생성
		RacingGame game = new RacingGame(winnerNames.split(","));

		game.start();
		game.start();
		game.start();

		// 최소 한명의 우승자가 나와야 한다.
		assertThat(game.getWinner()).isNotEmpty();
	}

	@ParameterizedTest
	@ValueSource(strings = {"M4", "코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("우승자 공동우승 테스트")
	void getAllWinnerTest(String winnerNames) {

		ForwardCarConditional forwardCarConditional = new ForwardCarConditional();

		// 자동차 경주 게임 객체 생성
		RacingGame game = new RacingGame(winnerNames.split(","));

		for (RacingCar car : game.getRacingCars().getCars()) {

			car.move(forwardCarConditional);
		}

		// Stream 으로 작성 연습
		game.getRacingCars().getCars()
			.forEach(racingCar -> racingCar.move(forwardCarConditional));

		// 모든 차량이 주행을 동일하게 했기 때문에 모든 차량이 우승자 이여야 한다.
		assertThat(game.getWinner().replace(" ", "")).isEqualTo(winnerNames);

		for (RacingCar car : game.getRacingCars().getCars()) {

			// 모든 차량이 주행을 2번했기 때문에 2
			assertThat(car.getDistance()).isEqualTo(2);
		}

	}

	@ParameterizedTest
	@ValueSource(strings = {"M4", "코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("우승자 주행거리 0 테스트")
	void getZeroWinnerTest(String winnerNames) {

		// 자동차 경주 게임 객체 생성 // 모든차량 주행거리 0
		RacingGame game = new RacingGame(winnerNames.split(","));

		// 주행을 안했기 때문에, 차량 리스트 전부가 우승자이여야 한다.
		assertThat(game.getWinner().replace(" ", "")).isEqualTo(winnerNames);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "       ", ", ,    , , , ", "SONATA,C CLASS"})
	@DisplayName("레이싱 게임 객체 예외처리 테스트")
	void createRacingExceptionTest(String carNames) {

		String[] names = carNames.split(",");

		assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(names));
	}

	@ParameterizedTest
	@ValueSource(strings = {"M4", "코브라,뱀", "520i,XC90,GV80", "M6,i30,A6,G90,EQ900"})
	@DisplayName("레이싱 게임 객체 생성 테스트")
	void createRacingGameTest(String carNames) {

		String[] names = carNames.split(",");
		RacingGame game = new RacingGame(names);

		assertThat(game.getRacingCars().getCars().size()).isEqualTo(names.length);
	}
}
