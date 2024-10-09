package step4.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step4.service.RacingGame.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.Car;
import step4.domain.CarAtDefaultStrategy;
import step4.domain.RacingHistory;
import step4.exception.RaceParamUnvalidException;

class RacingGameTest {
	private CarAtDefaultStrategy carAtDefaultStrategy;
	private Car car;
	private Integer prevPosition;

	@BeforeEach
	void setUp() {
		car = new Car();
		prevPosition = car.getPosition();
		carAtDefaultStrategy = new CarAtDefaultStrategy();
	}

	@Test
	@DisplayName("자동차는 입력받은 n대 만큼 생성되는지 체크하는 테스트")
	void carCountTest() {
		int inputCarCount = 4;
		List<Car> cars = makeCars(inputCarCount);
		for (Car car : cars) {
			assertThat(car).isNotNull();
		}
		assertThat(cars.size()).isEqualTo(inputCarCount);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		int inputMoveCount = 5;
		RacingHistory racingResult = race(1, inputMoveCount);
		assertThat(racingResult.getMovedCount()).isEqualTo(inputMoveCount);
	}

	@Test
	@DisplayName("4 이상일 시 움직이는 CarAtDefaultStrategy 테스트")
	void carDefaultStrategyMoveTest() {
		car.setMoveStrategy(carAtDefaultStrategy);
		car.move(CarAtDefaultStrategy.MIN_MOVE_VALUE);
		Integer expectedPosition = prevPosition + carAtDefaultStrategy.speed();
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("4 미만일 시 움직이지 않는 CarAtDefaultStrategy 테스트")
	void carDefaultStrategyStopTest() {
		car.setMoveStrategy(carAtDefaultStrategy);
		car.move(CarAtDefaultStrategy.MIN_MOVE_VALUE - 1);
		assertThat(car.getPosition()).isEqualTo(prevPosition);
	}

	@Test
	@DisplayName("전략을 정하지 않을시 기본 전략으로 움직이는지 확인하는 테스트")
	void noStrategyTest() {
		car.move(CarAtDefaultStrategy.MIN_MOVE_VALUE);
		Integer expectedPosition = prevPosition + carAtDefaultStrategy.speed();
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("입력이 잘못되었을경우 익셉션 발생 테스트")
	void unExpectedInputExceptionTest() {
		assertThatThrownBy(() -> race(1, -1)).isInstanceOf(RaceParamUnvalidException.class);
		assertThatThrownBy(() -> race(-1, 1)).isInstanceOf(RaceParamUnvalidException.class);
	}
}