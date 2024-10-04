package step3.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.Car;
import step3.exception.RaceParamUnvalidException;

class RacingGameTest {

	@Test
	@DisplayName("자동차는 입력받은 n대 만큼 생성되는지 체크하는 테스트")
	void carCountTest() {
		RacingGame racingGame = new RacingGame();
		int carCount = 4;
		racingGame.setRaceInfo(carCount, 1);
		for (Car car : racingGame.getCars()) {
			assertThat(car).isNotNull();
		}
		assertThat(racingGame.getCars()).hasSize(carCount);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		RacingGame racingGame = new RacingGame();
		int moveCount = 5;
		racingGame.race(4, moveCount);
		for (Car car : racingGame.getCars()) {
			assertThat(car.getMoveCalledCount()).isEqualTo(moveCount);
		}
	}

	@Test
	@DisplayName("이동을 시도 할 시 4 이상이면 움직이고 4 미만일시 움직이지 않는 테스트")
	void carRandomMoveTest() {
		Car car = new Car();
		car.move(3);
		assertThat(car.getPosition()).isEqualTo(0);
		car.move(5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("입력이 잘못되었을경우 익셉션 발생 테스트")
	void unExpectedInputExceptionTest() {
		RacingGame racingGame = new RacingGame();
		assertThatThrownBy(() -> racingGame.race(1, -1)).isInstanceOf(RaceParamUnvalidException.class);
		assertThatThrownBy(() -> racingGame.race(-1, 1)).isInstanceOf(RaceParamUnvalidException.class);
	}
}