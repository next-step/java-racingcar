package step4.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step4.service.RacingGame.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.Car;
import step4.domain.DefaultRandomMoveStrategy;
import step4.domain.RacingHistory;
import step4.exception.RaceParamUnvalidException;

class RacingGameTest {
	private DefaultRandomMoveStrategy defaultRandomMoveStrategy;
	private Car car;
	private Integer prevPosition;

	@BeforeEach
	void setUp() {
		car = new Car();
		prevPosition = car.getPosition();
		defaultRandomMoveStrategy = new DefaultRandomMoveStrategy(new Random());
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
	@DisplayName("movable 값이 True 일때만 움직이는지 확인하는 테스트")
	void carDefaultRandomMoveTest() {
		car.setMoveStrategy(defaultRandomMoveStrategy);
		boolean movable = car.getMoveStrategy().movable();
		car.move(movable);
		if (movable) {
			Integer expectedPosition = prevPosition + defaultRandomMoveStrategy.speed();
			assertThat(car.getPosition()).isEqualTo(expectedPosition);
		} else {
			assertThat(car.getPosition()).isEqualTo(prevPosition);
		}
	}

	@Test
	@DisplayName("전략을 정하지 않을시 기본 전략으로 움직이는지 확인하는 테스트")
	void noStrategyTest() {
		boolean movable = car.getMoveStrategy().movable();
		car.move(movable);
		if (movable) {
			Integer expectedPosition = prevPosition + defaultRandomMoveStrategy.speed();
			assertThat(car.getPosition()).isEqualTo(expectedPosition);
		} else {
			assertThat(car.getPosition()).isEqualTo(prevPosition);
		}
	}

	@Test
	@DisplayName("입력이 잘못되었을경우 익셉션 발생 테스트")
	void unExpectedInputExceptionTest() {
		assertThatThrownBy(() -> race(1, -1)).isInstanceOf(RaceParamUnvalidException.class);
		assertThatThrownBy(() -> race(-1, 1)).isInstanceOf(RaceParamUnvalidException.class);
	}
}