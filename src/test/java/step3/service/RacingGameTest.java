package step3.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step3.service.RacingGame.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.Car;
import step3.exception.RaceParamUnvalidException;

class RacingGameTest {

	public static final int LOWER_VALUE_THAN_MIN_BOUND = 3;
	public static final int HIGHER_VALUE_THAN_MIN_BOUND = 5;

	@Test
	@DisplayName("자동차는 입력받은 n대 만큼 생성되는지 체크하는 테스트")
	void carCountTest() {
		int carCount = 4;
		int[][] raceResult = race(carCount, 1);
		int[] carPositionList = raceResult[0];
		assertThat(carPositionList).hasSize(carCount);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		int moveCount = 5;
		int[][] racingResult = race(4, moveCount);
		int movedCount = racingResult.length;
		assertThat(movedCount).isEqualTo(moveCount);
	}

	@Test
	@DisplayName("이동을 시도 할 시 4 이상이면 움직이고 4 미만일시 움직이지 않는 테스트")
	void carRandomMoveTest() {
		Car car = new Car();
		int prevPosition = car.getPosition();
		car.move(LOWER_VALUE_THAN_MIN_BOUND);
		assertThat(car.getPosition()).isEqualTo(prevPosition);
		car.move(HIGHER_VALUE_THAN_MIN_BOUND);
		assertThat(car.getPosition()).isNotEqualTo(prevPosition);
	}

	@Test
	@DisplayName("입력이 잘못되었을경우 익셉션 발생 테스트")
	void unExpectedInputExceptionTest() {
		assertThatThrownBy(() -> race(1, -1)).isInstanceOf(RaceParamUnvalidException.class);
		assertThatThrownBy(() -> race(-1, 1)).isInstanceOf(RaceParamUnvalidException.class);
	}
}