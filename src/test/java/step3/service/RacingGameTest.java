package step3.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step3.service.RacingGame.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.Car;
import step3.domain.CarAtDefaultStrategy;
import step3.domain.CarAtMorningStrategy;
import step3.domain.CarAtNightStrategy;
import step3.domain.RacingHistory;
import step3.exception.RaceParamUnvalidException;

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
	@DisplayName("짝수일 때 움직이는 CarAtMorningStrategy 테스트")
	void carAtMorningStrategyMoveTest() {
		CarAtMorningStrategy carAtMorningStrategy = new CarAtMorningStrategy();
		car.setMoveStrategy(carAtMorningStrategy);
		car.move(2);
		Integer expectedPosition = prevPosition + carAtMorningStrategy.speed();
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("홀수일 때 멈추는 CarAtMorningStrategy 테스트")
	void carAtMorningStrategyStopTest() {
		CarAtMorningStrategy carAtMorningStrategy = new CarAtMorningStrategy();
		car.setMoveStrategy(carAtMorningStrategy);
		car.move(3);
		assertThat(car.getPosition()).isEqualTo(prevPosition);
	}

	@Test
	@DisplayName("3의 배수일 때 움직이는 carAtNightStrategy 테스트")
	void carAtNightStrategyMoveTest() {
		CarAtNightStrategy carAtNightStrategy = new CarAtNightStrategy();
		car.setMoveStrategy(carAtNightStrategy);
		car.move(3);
		Integer expectedPosition = prevPosition + carAtNightStrategy.speed();
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("3의 배수가 아닐 때 멈추는 carAtNightStrategy 테스트")
	void carAtNightStrategyStopTest() {
		CarAtNightStrategy carAtNightStrategy = new CarAtNightStrategy();
		car.setMoveStrategy(carAtNightStrategy);
		car.move(4);
		assertThat(car.getPosition()).isEqualTo(prevPosition);
	}

	@Test
	@DisplayName("입력이 잘못되었을경우 익셉션 발생 테스트")
	void unExpectedInputExceptionTest() {
		assertThatThrownBy(() -> race(1, -1)).isInstanceOf(RaceParamUnvalidException.class);
		assertThatThrownBy(() -> race(-1, 1)).isInstanceOf(RaceParamUnvalidException.class);
	}
}