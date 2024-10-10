package step4.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step4.service.RacingGame.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.car.Car;
import step4.domain.car.CarList;
import step4.domain.movestrategy.DefaultRandomMoveStrategy;
import step4.domain.racehistory.RacingHistory;
import step4.domain.view.UserInput;

class RacingGameTest {
	private final static int TEST_MOVE_COUNT = 3;
	private final static int TEST_CAR_COUNT = 5;
	private final static String TEST_CAR_STRING = "a,b,c,d,e";
	private DefaultRandomMoveStrategy defaultRandomMoveStrategy;
	private Car car;
	private Integer prevPosition;
	private UserInput userInput;

	@BeforeEach
	void setUp() {
		car = new Car("singleCar");
		prevPosition = car.getPosition();
		defaultRandomMoveStrategy = new DefaultRandomMoveStrategy(new Random());
		userInput = new UserInput(TEST_MOVE_COUNT, TEST_CAR_STRING);
	}

	@Test
	@DisplayName("자동차는 입력받은 이름의 개수만큼 생성되는지 체크하는 테스트")
	void carCountTest() {
		CarList cars = CarList.from(userInput.getNameList());
		for (Car car : cars.getList()) {
			assertThat(car).isNotNull();
		}
		assertThat(cars.getSize()).isEqualTo(TEST_CAR_COUNT);
	}

	@Test
	@DisplayName("자동차는 입력받은 n번 만큼 이동을 시도하는지 체크하는 테스트")
	void carMoveTest() {
		RacingHistory racingResult = race(userInput);
		assertThat(racingResult.getMovedCount()).isEqualTo(TEST_MOVE_COUNT);
	}

	@Test
	@DisplayName("movable 값이 True 일때만 움직이는지 확인하는 테스트")
	void carStrategyMoveTest() {
		car.move(true);
		Integer expectedPosition = prevPosition + defaultRandomMoveStrategy.speed();
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("movable 값이 False 일때는 안 움직이는지 확인하는 테스트")
	void carStrategyStopTest() {
		car.move(false);
		assertThat(car.getPosition()).isEqualTo(prevPosition);
	}

	@Test
	@DisplayName("전략을 정하지 않을시 기본 전략으로 움직이는지 확인하는 테스트")
	void noStrategyTest() {
		assertThat(car.getMoveStrategy()).isInstanceOf(DefaultRandomMoveStrategy.class);
	}

}